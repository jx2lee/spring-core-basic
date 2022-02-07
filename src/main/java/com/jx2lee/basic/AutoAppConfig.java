package com.jx2lee.basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // AppConfig.java 가 등록되지 않게 exclude option 추가
        // 보통 설정 정보를 스캔 대상에서 제외하지 않지만 기존 예제 코드를 최대한 남기기 위해 추가하였다.
)
public class AutoAppConfig {

}
