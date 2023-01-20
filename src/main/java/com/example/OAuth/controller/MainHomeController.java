package com.example.OAuth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainHomeController {
    @GetMapping("/")
    public String home(Model model){        
        model.addAttribute("data", "저는 박종국입니다.");
        return "hello";
    }
    
}
