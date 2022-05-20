package com.matjo.pickafood.admin.food.service;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;
import com.matjo.pickafood.admin.food.dto.FoodDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FoodService {
    ListResponseDTO<FoodDTO> getList(ListDTO listDTO); //문의글 목록
    void insert(FoodDTO foodDTO);
}
