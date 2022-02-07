package com.jx2lee.basic.discount;

import com.jx2lee.basic.member.Grade;
import com.jx2lee.basic.annotation.MainDiscountPolicy;
import com.jx2lee.basic.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
