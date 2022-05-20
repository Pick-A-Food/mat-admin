package com.matjo.pickafood.admin.reply.service;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.notice.mapper.NoticeMapper;
import com.matjo.pickafood.admin.reply.domain.ReplyVO;
import com.matjo.pickafood.admin.reply.dto.ReplyDTO;
import com.matjo.pickafood.admin.reply.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReplyServiceImpl implements ReplyService{

    private final NoticeMapper noticeMapper;
    private final ReplyMapper replyMapper;
    private final ModelMapper modelMapper;

    //댓글 목록
    @Override
    public List<ReplyDTO> getListOfBoard(Integer boardSeq, ListDTO listDTO) {
        List<ReplyVO> replyList = replyMapper.selectListOfBoard(boardSeq, listDTO);

        List<ReplyDTO> dtoList = replyList.stream().map(reply -> modelMapper.map(reply, ReplyDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public int register(ReplyDTO replyDTO) {
        ReplyVO replyVO = modelMapper.map(replyDTO, ReplyVO.class);

        replyMapper.insert(replyVO);
        noticeMapper.updateReplyCount(replyDTO.getBoardSeq(), 1);

        return replyMapper.selectTotalOfBoard(replyDTO.getBoardSeq());
    }
}
