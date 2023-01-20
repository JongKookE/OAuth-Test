package com.example.OAuth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.OAuth.member.Member;
import com.example.OAuth.repository.MemberRepository;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //회원가입
    public int join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(int memberId){
        return memberRepository.findById(memberId);
    }
    public String goToMySql(Member member){
        String sql = "INSERT INTO member VALUES (" + member.getId() + "," + member.getName() + "," + member.getEmail_1() + "@" + member.getEmail_2() + ")";
        return sql;
    }
}
