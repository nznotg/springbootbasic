package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryMemberRepository implements MemberRepository{
    //
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public void clearStore() {
        store.clear();
    }

    @Override
    public Member save(Member member) {
        // member 의 name은 사용자가 회원가입하면서 작성함을 가정
        // member 의 id 지정 후 store(DB)에 저장
        // 셋팅된 member return
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
