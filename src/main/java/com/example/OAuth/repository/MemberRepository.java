package com.example.OAuth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.OAuth.member.Member;

@Repository
public interface MemberRepository{
    Member save(Member member);
    Optional<Member> findById(int id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
