package com.example.OAuth.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.stereotype.Component;

import com.example.OAuth.repository.MemberRepository;

@Component                                          //interface를 이어받음
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Integer, Member> store = new HashMap<>();
    private static int sequence = 0;


    @Override
    public Member save(Member member) {        
        member.setId(++sequence);
        store.put(member.getId(), member);
        return  member;
    }

    @Override
    public Optional<Member> findById(int id) {        
        return Optional.ofNullable(store.get(id)); //Optional의 ofNullable -> nu;; check
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member ->member.getName().equals(name)).findAny(); //람다함수 사용법 배우도록 하자
    }

    @Override
    public List<Member> findAll() {        
        return new ArrayList<>(store.values()); //store의 모든걸 찾기?
    }
    
    public void clearStore(){
        store.clear();
    }
}
