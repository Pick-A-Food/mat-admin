package com.matjo.pickafood.admin.file.service;

import com.matjo.pickafood.admin.file.domain.FileVO;
import com.matjo.pickafood.admin.file.dto.FileDTO;
import com.matjo.pickafood.admin.file.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class FileServiceImpl implements FileService{

    private final FileMapper fileMapper;
    private final ModelMapper modelMapper;

    @Override
    public void remove(String uuid) {
        fileMapper.delete(uuid);
    }

    @Override
    public FileDTO register(FileDTO fileDTO) {
        fileMapper.insert(fileDTO);
        return fileDTO;
    }

    
    //첨부파일 보이기
    @Override
    public List<FileDTO> getReadFiles(Integer bno) {
        List<FileDTO> list;
        list = fileMapper.getReadFiles(bno);

        return list;
    }
}
