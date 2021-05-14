package com.jx2lee.core.order;

import com.jx2lee.core.discount.FixDiscountPolicy;
import com.jx2lee.core.member.Grade;
import com.jx2lee.core.member.Member;
import com.jx2lee.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
