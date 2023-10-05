package com.trading.upbit.schedular;

import com.trading.upbit.feignClient.MarketCodeInquiry;
import com.trading.upbit.feignClient.MarketPriceInquiry;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarketPriceScheduler {

    private final MarketCodeInquiry marketCodeInquiry;
    private final MarketPriceInquiry marketPriceInquiry;

    @Scheduled(fixedDelayString = "${schedule.fixed.delay.upbit}")
    public void retrieveAndSaveTicker() {
        // 전체 종목 조회
    }
}
