package com.jx2lee.core;

import com.jx2lee.core.member.Grade;
import com.jx2lee.core.member.Member;
import com.jx2lee.core.member.MemberService;
import com.jx2lee.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member: " + member.getName());
        System.out.println("find member: " + findMember.getName());

    }
}
