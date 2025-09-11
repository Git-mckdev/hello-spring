package com.overflow.hello_spring.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.overflow.hello_spring.domain.Member;
import com.overflow.hello_spring.repository.MemoryMemberRepository;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        memberService = new MemberService(new MemoryMemberRepository());
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long savedId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(savedId).get();
        Assertions.assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void duplicateMemberException() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertEquals("이미 존재하는 회원입니다.", e.getMessage());
        // then
    }

    @Test
    void findMembers() {
        
    }

    @Test
    void findOne() {

    }
}
