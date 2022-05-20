package com.matjo.pickafood.admin.notice.service;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;
import com.matjo.pickafood.admin.file.dto.FileDTO;
import com.matjo.pickafood.admin.file.mapper.FileMapper;
import com.matjo.pickafood.admin.notice.domain.NoticeVO;
import com.matjo.pickafood.admin.notice.dto.NoticeDTO;
import com.matjo.pickafood.admin.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper noticeMapper;
    private final ModelMapper modelMapper;
    private final FileMapper fileMapper;

    //공지사항 목록
    @Override
    public ListResponseDTO<NoticeDTO> getList(ListDTO listDTO) {
        List<NoticeVO> noticeVOList = noticeMapper.selectList(listDTO);

        List<NoticeDTO> dtoList =
                noticeVOList.stream()
                        .map(noticeVO -> modelMapper.map(noticeVO, NoticeDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<NoticeDTO>builder()
                .dtoList(dtoList)
                .total(noticeMapper.getTotal(listDTO))
                .build();
    }

    //공지사항 상세 페이지 - 조회
    @Override
    public NoticeDTO getOne(Integer bno) {
        int boardSeq = bno;
        NoticeVO noticeVO = noticeMapper.selectOne(boardSeq);
        NoticeDTO noticeDTO = modelMapper.map(noticeVO, NoticeDTO.class);
        return noticeDTO;
    }


    //공지 등록
    @Override
    @Transactional
    public void register(NoticeDTO noticeDTO) {

        NoticeVO noticeVO = modelMapper.map(noticeDTO, NoticeVO.class);
        noticeMapper.insert(noticeVO);
        log.info("boardSeq: {}", noticeVO.getBoardSeq());

        if (noticeDTO.getFileSeq() != null) {
            String[] fileSeqArray = noticeDTO.getFileSeq().split("\\,");
            log.info("file count : {}", fileSeqArray.length);
            for (int i = 0; i < fileSeqArray.length; i++) {
                FileDTO fileDTO = FileDTO.builder()
                        .boardSeq(noticeVO.getBoardSeq())
                        .fileSeq(Integer.parseInt(fileSeqArray[i]))
                        .build();
                fileMapper.insertBoardFile(fileDTO);
            }
        }

    }

}
