package com.jx2lee.basic.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long MemberId);
}
