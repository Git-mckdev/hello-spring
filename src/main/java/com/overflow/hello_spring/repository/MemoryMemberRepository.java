package com.overflow.hello_spring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.overflow.hello_spring.domain.Member;

public class MemoryMemberRepository implements MemberRepository {

    private static long sequence = 0L;
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public Member save(Member member) {
        member.setId(++sequence);

        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 람다식 사용
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}