package com.trading.upbit.feignClient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MarketPriceInquiryTest {

    private final String markets = "KRW-BTC";

    @Autowired
    private MarketPriceInquiry marketPriceInquiry;

    @Test
    final void retrieve_ticker_test() {
        ResponseEntity<String> upbitReturn = marketPriceInquiry.getStockTickerPrice(markets);
        System.out.println(upbitReturn);
        assertThat(upbitReturn).isNotNull();
    }
}
