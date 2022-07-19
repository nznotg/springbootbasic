package com.example.hellospring.Service;

import com.example.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    //
    MemberService memberService = new MemberService();

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("choi");

        //when
        Long saveId = memberService.join(member);

        //then
        Member foundMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(foundMember.getName());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}