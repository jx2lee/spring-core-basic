package com.jx2lee.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulServiceV1 statefulServiceV1 = ac.getBean(StatefulServiceV1.class);
        StatefulServiceV1 statefulServiceV2 = ac.getBean(StatefulServiceV1.class);

        //ThreadA: A사용자 10000원 주문
        statefulServiceV1.order("userA", 10000);
        //ThreadB: B사용자 10000원 주문
        statefulServiceV1.order("userB", 20000);

        //ThreadA: A사용자 주문 금액 조회
        int price = statefulServiceV1.getPrice();
        System.out.println("price = " + price);

        assertThat(statefulServiceV1.getPrice()).isEqualTo(statefulServiceV2.getPrice());
    }

    @Test
    @DisplayName("지역변수를 사용하여 statefulServiceSingleton 테스트를 성공한다.")
    void statefulServiceSingleton2() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulServiceV2 statefulServiceV1 = ac.getBean(StatefulServiceV2.class);
        StatefulServiceV2 statefulServiceV2 = ac.getBean(StatefulServiceV2.class);

        //ThreadA: A사용자 10000원 주문금액을 지역변수로 생성
        int userAPrice = statefulServiceV1.order("userA", 10000);
        //ThreadB: B사용자 10000원 주문금액을 지역변수로 생성
        int userBPrice = statefulServiceV2.order("userB", 20000);

        //ThreadA: A사용자 주문 금액과 B사용자 주문 금액 비교
        assertThat(userAPrice).isNotEqualTo(userBPrice);

    }

    static class TestConfig {
        @Bean
        public StatefulServiceV1 statefulServiceV1() {
            return new StatefulServiceV1();
        }
        @Bean
        public StatefulServiceV2 statefulServiceV2() {
            return new StatefulServiceV2();
        }
    }

}
