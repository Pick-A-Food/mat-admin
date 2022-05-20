package com.matjo.pickafood.admin.reply.service;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.reply.dto.ReplyDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ReplyService {
    List<ReplyDTO> getListOfBoard(Integer boardSeq, ListDTO listDTO);
    int register(ReplyDTO replyDTO);
}
