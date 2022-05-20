package com.matjo.pickafood.admin.report.controller;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;
import com.matjo.pickafood.admin.common.dto.PageMaker;
import com.matjo.pickafood.admin.report.dto.ReportDTO;
import com.matjo.pickafood.admin.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/report/")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    //list
    @GetMapping("/")
    public String basic() {
        return "redirect:/report/memberReport";
    }

    //회원 신고 list 페이지
    @GetMapping("/memberReport")
    public void memberReportList(ListDTO listDTO, Model model) {
        log.info("report list.........");

        ListResponseDTO<ReportDTO> responseDTO = reportService.getList(listDTO);
        model.addAttribute("dtoList", responseDTO.getDtoList());
        model.addAttribute("total", responseDTO.getTotal());
        int total = responseDTO.getTotal();
        model.addAttribute("pageMaker", new PageMaker(listDTO.getPage(), total));
    }


    //회원 신고 상세 페이지
    @GetMapping("/memberReport/read/{bno}")
    public String read(@PathVariable("bno") Integer bno, ListDTO listDTO, Model model){
        model.addAttribute("dto", reportService.getOne(bno));

        return "/report/memberReportRead";
    }

    //급식 신고 list 페이지
    @GetMapping("/schoolReport")
    public String schoolReportList() {
        
        
        return "/report/schoolReport";
    }

    //알레르기 신고 list 페이지
    @GetMapping("/allergyReport")
    public String allergyReportList() {
        
        
        return "/report/allergyReport";
    }




}
