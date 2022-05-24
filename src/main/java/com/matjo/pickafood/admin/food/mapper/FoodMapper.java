package com.matjo.pickafood.admin.food.mapper;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.mapper.GenericMapper;
import com.matjo.pickafood.admin.food.domain.CompanyVO;
import com.matjo.pickafood.admin.food.domain.FoodVO;

import java.util.List;

public interface FoodMapper extends GenericMapper<FoodVO, Integer> {
    List<CompanyVO> companyList(ListDTO listDTO);
    int getCompanyTotal(ListDTO listDTO);
}
