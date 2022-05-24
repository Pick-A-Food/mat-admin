package com.matjo.pickafood.admin.member.controller;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.member.dto.MemberDTO;
import com.matjo.pickafood.admin.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/list")
  public void list(ListDTO listDTO, Model model) {

    List<MemberDTO> memberDTOList = memberService.getList(listDTO);
    model.addAttribute("memberDTOList", memberDTOList);

  }

  @GetMapping("/registerSchool")
  public void registerSchool(Model model) {
    
  }
}
