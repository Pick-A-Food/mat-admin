package com.matjo.pickafood.admin.notice.controller;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;
import com.matjo.pickafood.admin.common.dto.PageMaker;
import com.matjo.pickafood.admin.file.dto.FileDTO;
import com.matjo.pickafood.admin.file.service.FileService;
import com.matjo.pickafood.admin.notice.dto.NoticeDTO;
import com.matjo.pickafood.admin.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/notice/")
public class NoticeController {

    private final NoticeService noticeService ;
    private final FileService fileService;

    //list
    @GetMapping("/")
    public String basic(){
        return "redirect:/notice/list";
    }

    @GetMapping("/list")
    public void list(ListDTO listDTO, Model model) {
        //log.info("notice list.........");

        ListResponseDTO<NoticeDTO> responseDTO = noticeService.getList(listDTO);

        model.addAttribute("dtoList", responseDTO.getDtoList());
        model.addAttribute("total", responseDTO.getTotal());

        log.info("----------------------------------------------------");
        log.info("----------------------------------------------------");
        log.info(responseDTO.getDtoList());
        log.info("----------------------------------------------------");
        log.info("----------------------------------------------------");

        int total = responseDTO.getTotal();
        model.addAttribute("pageMaker", new PageMaker(listDTO.getPage(), total));
    }

    //등록
    @GetMapping("/register")
    public String register(){

        return "/notice/register";
    }

    //등록 완료
    @PostMapping("/register")
    public String registerPOST(NoticeDTO noticeDTO, RedirectAttributes rttr){
        //log.info("등록 시....post................");
        //log.info(noticeDTO);

        //log.info("noticeDTO :  {} ", noticeDTO);

        noticeService.register(noticeDTO);
        rttr.addFlashAttribute("result", 123);

        return "redirect:/notice/list";
    }

    //상세 페이지지 조회
    @GetMapping("/read/{bno}")
    public String read(@PathVariable("bno") Integer bno, ListDTO listDTO, Model model){

        // log.info("==========bno: "+bno);
        // log.info("======listDTO: "+listDTO);

        model.addAttribute("dto", noticeService.getOne(bno));
        ;

        List<FileDTO> fileList = fileService.getReadFiles(bno);
        model.addAttribute("files", fileList);

        // log.info("-------- file 자료--------------");
        // log.info(fileList);

        return "/notice/read";
    }



}