package com.matjo.pickafood.admin.file.mapper;

import com.matjo.pickafood.admin.common.mapper.GenericMapper;
import com.matjo.pickafood.admin.file.domain.FileVO;
import com.matjo.pickafood.admin.file.dto.FileDTO;

import java.util.List;

public interface FileMapper extends GenericMapper<FileVO, Integer> {

    void insert(FileDTO fileDTO); //mapping 테이블에 이미지 등록
    void insertBoard(FileVO fileVO);
    void delete(String uuid);;

    void insertBoardFile(FileDTO fileDTO);//이미지 삭제
    List<FileDTO> getReadFiles(Integer bno); //이미지 불러오기
}
