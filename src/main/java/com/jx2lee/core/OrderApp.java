package com.jx2lee.core;

import com.jx2lee.core.member.Grade;
import com.jx2lee.core.member.Member;
import com.jx2lee.core.member.MemberServiceImpl;
import com.jx2lee.core.order.Order;
import com.jx2lee.core.order.OrderService;
import com.jx2lee.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberServiceImpl memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
