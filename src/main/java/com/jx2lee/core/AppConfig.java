package com.jx2lee.core;

import com.jx2lee.core.discount.FixDiscountPolicy;
import com.jx2lee.core.member.MemberService;
import com.jx2lee.core.member.MemberServiceImpl;
import com.jx2lee.core.member.MemoryMemberRepository;
import com.jx2lee.core.order.OrderService;
import com.jx2lee.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

    }
}
