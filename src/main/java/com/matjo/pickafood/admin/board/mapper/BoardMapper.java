package com.matjo.pickafood.admin.board.mapper;

import com.matjo.pickafood.admin.board.vo.AttachFile;
import com.matjo.pickafood.admin.board.vo.BoardVO;
import com.matjo.pickafood.admin.common.mapper.GenericMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BoardMapper extends GenericMapper<BoardVO, Integer> {

    void updateReplyCount(@Param("boardSeq") Integer bno, @Param("amount")  int amount);
    List<AttachFile> selectFiles(Integer bno);

}
