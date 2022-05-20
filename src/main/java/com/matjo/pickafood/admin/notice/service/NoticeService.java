package com.matjo.pickafood.admin.notice.service;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;
import com.matjo.pickafood.admin.notice.dto.NoticeDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface NoticeService {
    ListResponseDTO<NoticeDTO> getList(ListDTO listDTO); //공지사항 글 목록
    NoticeDTO getOne(Integer boardSeq); //공지 상세 페이지
    void register(NoticeDTO noticeDTO); //공지 등록

}
