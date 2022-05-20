package com.matjo.pickafood.admin.admin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@RequestMapping("/admin/")
@RequiredArgsConstructor
@Controller
public class AdminController {

    @GetMapping("/myPage")
    public void getMyPage(){
    }
}
