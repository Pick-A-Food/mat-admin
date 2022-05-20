package com.matjo.pickafood.admin.food.controller;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;
import com.matjo.pickafood.admin.common.dto.PageMaker;
import com.matjo.pickafood.admin.food.dto.FoodDTO;
import com.matjo.pickafood.admin.food.service.FoodService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/food/")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    //list
    @GetMapping("/")
    public String basic(){
        return "redirect:/food/list";
    }

    //list 페이지
    @GetMapping("/list")
    public void list(ListDTO listDTO, Model model){

        log.info("food list.........");
        // log.info("page : "+page);

        ListResponseDTO<FoodDTO> responseDTO = foodService.getList(listDTO);
        model.addAttribute("dtoList", responseDTO.getDtoList());
        model.addAttribute("total", responseDTO.getTotal());
        int total = responseDTO.getTotal();
        model.addAttribute("pageMaker", new PageMaker(listDTO.getPage(), total));

    }
}
