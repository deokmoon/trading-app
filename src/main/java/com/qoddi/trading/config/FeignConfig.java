package com.qoddi.trading.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableFeignClients("com.qoddi.trading.upbit.feignClient")
public class FeignConfig {
    /**
     * NONE: 로깅하지 않음(기본값)
     * BASIC: 요청 메소드와 URI와 응답 상태와 실행시간만 로깅함
     * HEADERS: 요청과 응답 헤더와 함께 기본 정보들을 남김
     * FULL: 요청과 응답에 대한 헤더와 바디, 메타 데이터를 남김
     */
    @Bean
    Logger.Level feignLoggerLevel() {
//        if (activeProfile.equals(PRODUCTION.getProfileString())) {
//            return HEADERS;
//        }
        return Logger.Level.FULL;
    }

    /**
     * IOException이 발생한 경우에만 처리, 이외의 경우에 재시도 -> Spring-Retry, 인터셉터 등의 방법 존재
     * 0.1초의 간격으로 시작해 최대 2초의 간격으로 점점 증가하며, 최대3번 재시도한다.
     */
    @Bean
    Retryer.Default retryer() { //
        return new Retryer.Default(100L, TimeUnit.SECONDS.toMillis(2L), 3);
    }
}
