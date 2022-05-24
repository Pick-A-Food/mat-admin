package com.matjo.pickafood.admin.board.controller;

import com.matjo.pickafood.admin.board.service.BoardService;
import com.matjo.pickafood.admin.board.dto.BoardDTO;
import com.matjo.pickafood.admin.board.dto.UploadResultDTO;
import com.matjo.pickafood.admin.common.dto.*;
import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Log4j2
@RequestMapping("/board/")
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String basic() {return "redirect:/board/list";}

    @GetMapping("/list")
    public void list(ListDTO listDTO, Model model) {
        log.info("Board List 입니다...");
        log.info("Page : " + listDTO);

        ListResponseDTO<BoardDTO> responseDTO = boardService.getList(listDTO);
        model.addAttribute("boardList", responseDTO.getDtoList());

        int total = responseDTO.getTotal();
        model.addAttribute("pageMaker", new PageMaker(listDTO.getPage(), total));

    }

    @GetMapping("/register")
    public void registerGET(){

    }

    @PostMapping("/register")
    public String registerPOST (BoardDTO boardDTO, RedirectAttributes rttr){

        log.info("register..." + boardDTO);

        boardService.register(boardDTO);

        rttr.addFlashAttribute("result", boardDTO.getBoardSeq());

        return "redirect:/board/list";

    }

    @GetMapping("/read/{boardSeq}")
    public String read(@PathVariable("boardSeq") Integer boardSeq, ListDTO listDTO, Model model){

        log.info(".read");
        model.addAttribute("listDTO", listDTO);
        model.addAttribute("board", boardService.getOne(boardSeq));

        return "/board/read";
    }

    @GetMapping("/modify/{boardSeq}")
    public String modifyGET(@PathVariable("boardSeq") Integer boardSeq, ListDTO listDTO, Model model){
        log.info("modify boardSeq= " + boardSeq + "/ " + listDTO);

        model.addAttribute("board", boardService.getOne(boardSeq));

        return "/board/modify";
    }

    @PostMapping("/modify/{boardSeq}")
    public String modifyPOST(@PathVariable("boardSeq") Integer boardSeq, BoardDTO boardDTO, ListDTO listDTO, RedirectAttributes rttr) {

        boardDTO.setBoardSeq(boardSeq);
        log.info("modify:" + boardDTO);
        boardService.update(boardDTO);
        rttr.addFlashAttribute("result", "modified");
        return "redirect:/board/read/" + boardSeq + listDTO.getLink();
    }

    @GetMapping({"/remove/{boardSeq}"})
    public String getNotSupported(){
        return "redirect:/board/list";
    }

    @PostMapping("/remove/{boardSeq}")
    public String removePost(@PathVariable("boardSeq") Integer boardSeq, RedirectAttributes rttr) {

        boardService.remove(boardSeq);
        rttr.addFlashAttribute("result", "removed");
        return "redirect:/board/list";
    }

    @GetMapping("/files/{boardSeq}")
    @ResponseBody
    public List<UploadResultDTO> getFiles(@RequestParam("boardSeq") Integer boardSeq){

        return boardService.getFiles(boardSeq);
    }

    }
