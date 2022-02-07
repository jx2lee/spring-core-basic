package com.jx2lee.basic.discount;

import com.jx2lee.basic.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
