package io.github.jx2lee.spring.core.basic.order;

import com.jx2lee.basic.AppConfig;
import com.jx2lee.basic.member.Grade;
import com.jx2lee.basic.member.Member;
import com.jx2lee.basic.member.MemberService;
import com.jx2lee.basic.order.Order;
import com.jx2lee.basic.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


        //then
    }
}
