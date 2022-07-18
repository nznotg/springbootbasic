package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    //
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //Test 가 끝날 때마다 데이터를 clear 시켜줘야 한다.
    // @AfterEach annotation 을 통해 테스트 하나가 끝날 때마다 해당 annotation이 있는 메소드가 실행된다.
    // 해당 메소드 안에는 메모리를 clear 시켜주는 메소드를 실행하도록 하면 된다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }


    @Test
    public void save() {
        // 실제 로직으로 저장해보고 저장한 된 값과 테스트한 데이터(member)가 같은지 비교하면 된다.
        Member member = new Member();
        member.setName("choi");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

//        Assertions.assertEquals(member, null); // fail
        assertThat(member).isEqualTo(result); // 요즘은 assertj 의 Assertions를 많이 씀
    }

    @Test
    public void findByName() {
        //
        Member member1 = new Member();
        member1.setName("spring");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring2").get();

        assertThat(member2).isEqualTo(result);
    }

    @Test
    public void findAll() {
        //
        Member member1 = new Member();
        repository.save(member1);
        Member member2 = new Member();
        repository.save(member2);
        Member member3 = new Member();
        repository.save(member3);

        List<Member> result = repository.findAll();

        //List의 검증은 List.size() 값을 비교로 테스트 할 수 있다.
        assertThat(result.size()).isEqualTo(3);


    }

}
