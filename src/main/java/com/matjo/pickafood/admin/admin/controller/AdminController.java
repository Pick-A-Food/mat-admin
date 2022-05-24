package com.matjo.pickafood.admin.admin.controller;

import com.matjo.pickafood.admin.admin.dto.AdminDTO;
import com.matjo.pickafood.admin.admin.service.AdminService;
import com.matjo.pickafood.admin.board.dto.BoardDTO;
import com.matjo.pickafood.admin.common.dto.ListDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@RequestMapping("/admin/")
@RequiredArgsConstructor
@Controller
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/myPage")
    public void getMyPage(){
    }

    @PostMapping("/myPage")
    public String modifyMyPage(@PathVariable("id") String id, AdminDTO adminDTO, RedirectAttributes rttr) {

        adminDTO.setId(id);
        adminService.update(adminDTO);

        rttr.addFlashAttribute("result", "modified");
        return "redirect:/admin/myPage";
    }

}
