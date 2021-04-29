package com.jx2lee.core;

import com.jx2lee.core.discount.DiscountPolicy;
import com.jx2lee.core.discount.FixDiscountPolicy;
import com.jx2lee.core.member.MemberRepository;
import com.jx2lee.core.member.MemberService;
import com.jx2lee.core.member.MemberServiceImpl;
import com.jx2lee.core.member.MemoryMemberRepository;
import com.jx2lee.core.order.OrderService;
import com.jx2lee.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    // Memory DB 말고 다른 DB 를 사용할 때는 이 부분만 수정하면 된다.
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    // 할인 정책이 바뀐 경우 아래 return 부분만 추가하여 수정하면 된다.
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
