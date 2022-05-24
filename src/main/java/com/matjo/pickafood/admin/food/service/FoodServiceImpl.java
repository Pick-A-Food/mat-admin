package com.matjo.pickafood.admin.food.service;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;
import com.matjo.pickafood.admin.food.domain.CompanyVO;
import com.matjo.pickafood.admin.food.domain.FoodVO;
import com.matjo.pickafood.admin.food.dto.CompanyDTO;
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
        List<FoodVO> foodVOList = foodMapper.selectList(listDTO);

        List<FoodDTO> dtoList =
                foodVOList.stream()
                        .map(foodVO -> modelMapper.map(foodVO, FoodDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<FoodDTO>builder()
                .dtoList(dtoList)
                .total(foodMapper.getTotal(listDTO))
                .build();
    }

    @Override
    public void insert(FoodDTO foodDTO) {
      FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
      foodMapper.insert(foodVO);
    }


    @Override
    public ListResponseDTO<CompanyDTO> getMain(ListDTO listDTO) {
        List<CompanyVO> companyList = foodMapper.companyList(listDTO);

        List<CompanyDTO> dtoList =
                companyList.stream()
                        .map(companyVO -> modelMapper.map(companyVO, CompanyDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<CompanyDTO>builder()
                .dtoList(dtoList)
                .total(foodMapper.getCompanyTotal(listDTO))
                .build();
    }
}
