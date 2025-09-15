package com.overflow.hello_spring.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.overflow.hello_spring.aop.TimeTraceAop;
import com.overflow.hello_spring.repository.JdbcMemberRepository;
import com.overflow.hello_spring.repository.JdbcTemplateMemberRepository;
import com.overflow.hello_spring.repository.JpaMemberRepository;
import com.overflow.hello_spring.repository.MemberRepository;

import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {

    //private final DataSource dataSource;
    //private final EntityManager em;
    private final MemberRepository memberRepository;

    /*@Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/
    /*@Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository); // memberRepository()
    }

    /*@Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }*/

    /*@Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/
}