package com.matjo.pickafood.admin.file.service;

import com.matjo.pickafood.admin.file.dto.FileDTO;

import java.util.List;

public interface FileService {
    void remove(String uuid);
    FileDTO register(FileDTO fileDTO);

    List<FileDTO> getReadFiles(Integer bno); //게시판 조회글에 첨부파일
}
