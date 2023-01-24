package com.example.OAuth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.OAuth.member.Member;

@Controller
public class MainHomeController {
    @GetMapping("/")
    public String home(Model model){        
        model.addAttribute("data", "저는 박종국입니다.");
        return "hello";
    }
    @PostMapping("/")
    public String sayHello(MemberForm repoMember){
        Member member = new Member();
        member.setName(repoMember.getName());
        return "hello";
    }
}
