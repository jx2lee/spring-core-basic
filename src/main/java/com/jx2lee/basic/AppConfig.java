package com.jx2lee.basic;

import com.jx2lee.basic.member.MemoryMemberRepository;
import com.jx2lee.basic.order.OrderServiceImpl;
import com.jx2lee.basic.discount.DiscountPolicy;
import com.jx2lee.basic.discount.RateDiscountPolicy;
import com.jx2lee.basic.member.MemberRepository;
import com.jx2lee.basic.member.MemberService;
import com.jx2lee.basic.member.MemberServiceImpl;
import com.jx2lee.basic.order.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository
    // @Bean orderService -> new MemoryMemberRepository

    // memberRepository 함수 호출 확인 (코드상)
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository

    // memberRepository 함수 호출 확인 (실제)
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    // Memory DB 말고 다른 DB 를 사용할 때는 이 부분만 수정하면 된다.
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    /**
     * 할인 정책
     * 할인 정책이 바뀐 경우 아래 return 부분만 추가하여 수정하면 된다.
     */
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
