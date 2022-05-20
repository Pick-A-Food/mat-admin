package com.matjo.pickafood.admin.inquiry.service;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;
import com.matjo.pickafood.admin.inquiry.domain.InquiryVO;
import com.matjo.pickafood.admin.inquiry.dto.InquiryDTO;
import com.matjo.pickafood.admin.inquiry.mapper.InquiryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class InquiryServiceImpl implements InquiryService {

    private final InquiryMapper inquiryMapper;
    private final ModelMapper modelMapper;

    //목록
    @Override
    public ListResponseDTO<InquiryDTO> getList(ListDTO listDTO) {
        List<InquiryVO> inquiryVOList = inquiryMapper.selectList(listDTO);

        List<InquiryDTO> dtoList =
                inquiryVOList.stream()
                        .map(inquiryVO -> modelMapper.map(inquiryVO, InquiryDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<InquiryDTO>builder()
                .dtoList(dtoList)
                .total(inquiryMapper.getTotal(listDTO))
                .build();
    }

    //문의 상세 페이지
    @Override
    public InquiryDTO getOne(Integer bno) {
        InquiryVO inquiryVO = inquiryMapper.selectOne(bno);
        InquiryDTO inquiryDTO = modelMapper.map(inquiryVO, InquiryDTO.class);


        return inquiryDTO;
    }

    //답변 달기
    @Override
    public void answerContent(InquiryDTO inquiryDTO) {
        //log.info("-------------dto--------------");
        //log.info(inquiryDTO.getAnswerContent());

        InquiryVO inquiryVO = InquiryVO.builder()
                .inquirySeq(inquiryDTO.getInquirySeq())
                .answerId(inquiryDTO.getAnswerId())
                .answerContent(inquiryDTO.getAnswerContent())
                .build();

        //log.info("vo: "+inquiryVO.getAnswerContent());


        inquiryMapper.answerContent(inquiryVO);
    }
}
