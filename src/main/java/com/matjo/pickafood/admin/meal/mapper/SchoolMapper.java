package com.matjo.pickafood.admin.meal.mapper;

import com.matjo.pickafood.admin.meal.domain.SchoolVO;

import java.util.List;

public interface SchoolMapper {

  void insert(SchoolVO school);

  List<SchoolVO> selectAll();

  List<SchoolVO> selectRegion(String regionCode);

  SchoolVO selectOne(String schoolCode);

}
