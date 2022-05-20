package com.matjo.pickafood.admin.notice.mapper;

import com.matjo.pickafood.admin.common.mapper.GenericMapper;
import com.matjo.pickafood.admin.notice.domain.NoticeVO;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper extends GenericMapper<NoticeVO, Integer> {
    void updateReplyCount(@Param("boardSeq") Integer bno, @Param("amount")  int amount);
}
