package com.matjo.pickafood.admin.meal.service;

import com.matjo.pickafood.admin.meal.dto.SchoolDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SchoolService {

  void insert(SchoolDTO schoolDTO);

  void insertAll(List<SchoolDTO> schoolDTOList);

  List<SchoolDTO> selectAll();

  List<SchoolDTO> selectSchoolsOfRegion(String regionCode);

  SchoolDTO selectOne(String schoolCode);

}
