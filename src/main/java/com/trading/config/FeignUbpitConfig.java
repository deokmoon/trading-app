package com.trading.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableFeignClients("com.trading.upbit")
public class FeignUbpitConfig {

    /**
     * NONE: 로깅하지 않음(기본값)
     * BASIC: 요청 메소드와 URI와 응답 상태와 실행시간만 로깅함
     * HEADERS: 요청과 응답 헤더와 함께 기본 정보들을 남김
     * FULL: 요청과 응답에 대한 헤더와 바디, 메타 데이터를 남김
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Retryer.Default retryer() { //
        return new Retryer.Default(100L, TimeUnit.SECONDS.toMillis(2L), 3);
    }
}
