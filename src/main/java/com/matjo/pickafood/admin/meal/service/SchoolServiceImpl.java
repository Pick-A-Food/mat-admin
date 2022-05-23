package com.matjo.pickafood.admin.meal.service;

import com.matjo.pickafood.admin.meal.domain.SchoolVO;
import com.matjo.pickafood.admin.meal.dto.SchoolDTO;
import com.matjo.pickafood.admin.meal.mapper.SchoolMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements SchoolService{

  private final ModelMapper modelMapper;
  private final SchoolMapper schoolMapper;

  @Override
  public void insert(SchoolDTO schoolDTO) {
    SchoolVO school = modelMapper.map(schoolDTO, SchoolVO.class);
    schoolMapper.insert(school);
  }

  @Override
  public void insertAll(List<SchoolDTO> schoolDTOList) {
    List<SchoolVO> schoolList = schoolDTOList.stream()
            .map(schoolDTO -> {
              return modelMapper.map(schoolDTO, SchoolVO.class);
            })
            .collect(Collectors.toList());
    schoolList.forEach(school -> schoolMapper.insert(school));
  }

  @Override
  public List<SchoolDTO> selectAll() {
    List<SchoolVO> schoolList = schoolMapper.selectAll();
    return schoolList.stream()
            .map(schoolVO -> modelMapper.map(schoolVO, SchoolDTO.class))
            .collect(Collectors.toList());
  }

  @Override
  public List<SchoolDTO> selectSchoolsOfRegion(String regionCode) {
    List<SchoolVO> schoolList = schoolMapper.selectRegion(regionCode);
    return schoolList.stream()
            .map(schoolVO -> modelMapper.map(schoolVO, SchoolDTO.class))
            .collect(Collectors.toList());
  }

  @Override
  public SchoolDTO selectOne(String schoolCode) {
    SchoolVO schoolVO = schoolMapper.selectOne(schoolCode);
    return modelMapper.map(schoolVO, SchoolDTO.class);
  }
}
