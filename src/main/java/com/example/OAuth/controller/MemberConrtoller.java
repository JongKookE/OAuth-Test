package com.example.OAuth.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.OAuth.member.Member;
import com.example.OAuth.service.MemberService;
@Controller
public class MemberConrtoller {
    private MemberService memberService;
    
    
    public MemberConrtoller(MemberService memberService){
        this.memberService = memberService;
    }
    
    @GetMapping("/members/new")
    public String createForm(){
        return "member/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        member.setEmail_1(form.getEmail_1());
        member.setEmail_2(form.getEmail_2());
        memberService.join(member);
        return "redirect:/";
    }
    
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);    
        return "member/memberList";
    }
}
