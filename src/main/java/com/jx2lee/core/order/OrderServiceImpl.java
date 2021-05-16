package com.jx2lee.core.order;

import com.jx2lee.core.annotation.MainDiscountPolicy;
import com.jx2lee.core.discount.DiscountPolicy;
import com.jx2lee.core.member.Member;
import com.jx2lee.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 자동으로 의존 관계를 주입하는 Autowired
    // 주입을 자동으로 주입하길 원하는 생성자에 해당 annotation 작성
    // RequiredArgsConstructor annotion 사용 시 아래 생성자를 자동으로 만들어준다.
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // Just for Test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
