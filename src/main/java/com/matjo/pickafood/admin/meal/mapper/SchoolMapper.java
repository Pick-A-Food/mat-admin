package com.matjo.pickafood.admin.meal.mapper;

import com.matjo.pickafood.admin.meal.domain.SchoolVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SchoolMapper {

  void insert(SchoolVO school);

  List<SchoolVO> selectAll();

  List<SchoolVO> selectRegion(String regionCode);

  List<SchoolVO> selectRegionAndName(@Param("regionCode")String regionCode, @Param("schoolName")String schoolName);

  SchoolVO selectOne(String schoolCode);

}
