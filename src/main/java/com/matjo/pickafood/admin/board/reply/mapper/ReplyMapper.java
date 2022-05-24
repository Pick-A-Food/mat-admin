package com.matjo.pickafood.admin.board.reply.mapper;

import com.matjo.pickafood.admin.board.reply.domain.ReplyVO;
import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.mapper.GenericMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ReplyMapper extends GenericMapper<ReplyVO, Integer> {
    List<ReplyVO> selectListOfBoard(@Param("boardSeq") Integer boardSeq, @Param("listDTO") ListDTO listDTO);

    int selectTotalOfBoard(Integer boardSeq);
}

