package com.jx2lee.core.order;

import com.jx2lee.core.discount.DiscountPolicy;
import com.jx2lee.core.discount.FixDiscountPolicy;
import com.jx2lee.core.member.Member;
import com.jx2lee.core.member.MemberRepository;
import com.jx2lee.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
