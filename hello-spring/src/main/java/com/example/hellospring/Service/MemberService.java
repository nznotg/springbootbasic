package com.example.hellospring.Service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    //
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * Membership Join
     */
    public Long join(Member member) {
        //이름 중복 체크(동일 회원 검증)
        validateDuplicateMember(member);
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("this member name already exists.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        //
        return memberRepository.findAll();
    }

    /**
     * id로 한 명의 회원 찾기
     */
    public Optional<Member> findOne(long memberId) {
        //
        return memberRepository.findById(memberId);
    }


}
