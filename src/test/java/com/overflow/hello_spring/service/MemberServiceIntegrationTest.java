package com.overflow.hello_spring.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.overflow.hello_spring.domain.Member;
import com.overflow.hello_spring.repository.MemberRepository;

@SpringBootTest
//@Transactional // 해당 어노테이션을 사용 시 테스트 후 DB가 롤백되지만, 어째서인지 정상적으로 작동하지 않음. (아마도 각 DB 명령을 롤백하도록 바뀐 것 같음.)
public class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("Spring 1");

        // when
        Long savedId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(savedId).get();
        Assertions.assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void duplicateMemberException() {
        Member member1 = new Member();
        member1.setName("Spring 1");

        Member member2 = new Member();
        member2.setName("Spring 1");

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertEquals("이미 존재하는 회원입니다.", e.getMessage());
    }
}