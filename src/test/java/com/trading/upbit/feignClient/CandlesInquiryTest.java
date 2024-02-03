package com.trading.upbit.feignClient;

import com.trading.controller.constants.CandlesUnitType;
import com.trading.domain.upbit.response.UpbitCandlesMinutesRes;
import com.trading.apiclient.upbit.CandlesInquiry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class CandlesInquiryTest {

    @Autowired
    private CandlesInquiry candlesInquiry;

    @Test
    public void getCandlesMinutes() {

        CandlesUnitType unit = CandlesUnitType.ONE;
        String market = "KRW-BTC";
        String DATE_FORMATTER = "yyyy-MM-dd'T'HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        String to = LocalDateTime.of(2023, 11, 1, 14, 0, 0).format(formatter);
        Integer count = 5;

        List<UpbitCandlesMinutesRes> upbitCandlesMinutesResList = candlesInquiry.getCandlesMinutes(unit.getCode(), market, to, count);

        upbitCandlesMinutesResList.forEach(upbitCandlesMinutesRes -> {
            assertThat(upbitCandlesMinutesRes.getMarket()).isEqualTo(market);
        });

    }

}
