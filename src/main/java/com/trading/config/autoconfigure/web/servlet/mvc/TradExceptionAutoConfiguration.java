package com.trading.config.autoconfigure.web.servlet.mvc;

import com.trading.common.annotation.EnableTradExceptionHandler;
import com.trading.common.exception.TradExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type;

@Slf4j
@Configuration
@ConditionalOnWebApplication(type = Type.SERVLET)
@ConditionalOnBean(annotation = EnableTradExceptionHandler.class)
public class TradExceptionAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "TradExceptionHandler", value = TradExceptionHandler.class)
    public TradExceptionHandler TradExceptionHandler() {
        log.info("TradExceptionAutoConfiguration:TradExceptionHandler");
        return new TradExceptionHandler();
    }

}
