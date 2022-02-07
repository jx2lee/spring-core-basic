package com.jx2lee.basic.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {
    // 동시성 이슈가 발생할 수 있으므로 원래는 ConcurrentHashMap
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
