package io.github.jx2lee.spring.core.basic.singleton;

import com.jx2lee.basic.AppConfig;
import com.jx2lee.basic.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링이 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회:  호출 시 마다 객체를 생성하는가? 를 확인하기 위해 객체를 생성한다.
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 다른 객체를 생성해보자.
        MemberService memberService2 = appConfig.memberService();

        //3. 참조값 확인 (두 객체의 참조값이 같은가 다른가 확인을 위함)
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("Singleton 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        singletonService1.logic();
        System.out.println("singletonService2 = " + singletonService2);
        singletonService2.logic();

        assertThat(singletonService1).isSameAs(singletonService2);
        //same == 참조값 비교
        //equal == 참조값 비교 X
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회:  호출 시 마다 객체를 생성하는가? 를 확인하기 위해 객체를 생성한다.
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        //2. 조회: 다른 객체를 생성해보자.
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //3. 참조값 확인 (두 객체의 참조값이 같은가 다른가 확인을 위함)
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isSameAs(memberService2);

    }
}
