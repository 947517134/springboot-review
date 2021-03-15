package com.webdev.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    @GetMapping("/jump")
    public String jump(Model model){

        model.addAttribute("msg","thymleaftest");
        model.addAttribute("link","shuaikeke.top");
        return "success";
    }
}
