package com.matjo.pickafood.admin.food.service;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;
import com.matjo.pickafood.admin.food.domain.FoodVO;
import com.matjo.pickafood.admin.food.dto.FoodDTO;
import com.matjo.pickafood.admin.food.mapper.FoodMapper;
import com.matjo.pickafood.admin.inquiry.domain.InquiryVO;
import com.matjo.pickafood.admin.inquiry.dto.InquiryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class FoodServiceImpl implements FoodService {

    private final FoodMapper foodMapper;
    private final ModelMapper modelMapper;

    @Override
    public ListResponseDTO<FoodDTO> getList(ListDTO listDTO) {
        List<FoodVO> inquiryVOList = foodMapper.selectList(listDTO);

        List<FoodDTO> dtoList =
                inquiryVOList.stream()
                        .map(foodVO -> modelMapper.map(foodVO, FoodDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<FoodDTO>builder()
                .dtoList(dtoList)
                .total(foodMapper.getTotal(listDTO))
                .build();
    }
}
