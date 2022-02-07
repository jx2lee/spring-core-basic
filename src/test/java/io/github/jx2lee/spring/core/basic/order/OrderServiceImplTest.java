package io.github.jx2lee.spring.core.basic.order;

import com.jx2lee.basic.discount.FixDiscountPolicy;
import com.jx2lee.basic.member.Grade;
import com.jx2lee.basic.member.Member;
import com.jx2lee.basic.member.MemoryMemberRepository;
import com.jx2lee.basic.order.Order;
import com.jx2lee.basic.order.OrderServiceImpl;
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
