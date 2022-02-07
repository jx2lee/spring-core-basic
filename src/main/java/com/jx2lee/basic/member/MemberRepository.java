package com.jx2lee.basic.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
