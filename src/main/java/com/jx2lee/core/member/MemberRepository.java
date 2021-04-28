package com.jx2lee.core.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
