package com.trading;

import com.trading.common.annotation.EnableTradApiResponse;
import com.trading.common.annotation.EnableTradExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Slf4j
//@EnableScheduling
@EnableTradApiResponse // 공통 응답 형식 사용
@EnableTradExceptionHandler // 공통 에러처리 사용
@ConfigurationPropertiesScan
@EntityScan
//@SpringBootApplication
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) // SpringSecurity 설정 무효화
public class TradingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingApplication.class, args);
		log.info("TRADING-APP");
	}

}
