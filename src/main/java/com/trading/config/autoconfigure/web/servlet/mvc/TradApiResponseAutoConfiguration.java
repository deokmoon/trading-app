package com.trading.config.autoconfigure.web.servlet.mvc;

import com.trading.common.annotation.EnableTradApiResponse;
import com.trading.config.aop.TradResponseBodyAdvice;
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
@ConditionalOnBean(annotation = EnableTradApiResponse.class)
public class TradApiResponseAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "responseBodyAdvice", value = TradResponseBodyAdvice.class)
    public TradResponseBodyAdvice responseBodyAdvice() {
        return new TradResponseBodyAdvice();
    }

}
