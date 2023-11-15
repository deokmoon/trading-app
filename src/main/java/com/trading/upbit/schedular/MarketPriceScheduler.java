package com.trading.upbit.schedular;

import com.trading.upbit.application.MarketPriceService;
import com.trading.upbit.dto.InquiryAllMarketInformationDto;
import com.trading.upbit.feignClient.MarketCodeInquiry;
import com.trading.upbit.feignClient.MarketPriceInquiry;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.trading.util.ConvertStringToDto.convertFromJson;

@Component
@RequiredArgsConstructor
public class MarketPriceScheduler {

    private final MarketPriceService marketPriceService;
    private final MarketCodeInquiry marketCodeInquiry;
    private final MarketPriceInquiry marketPriceInquiry;

//    @Scheduled(fixedDelayString = "${schedule.fixed.delay.upbit}")
    public void retrieveAndSaveTicker() {
        // 전체 종목 조회
        List<InquiryAllMarketInformationDto> marketInfoDtoList = convertFromJson(marketCodeInquiry.getAllMarketInformation().getBody(), InquiryAllMarketInformationDto.class);
        marketPriceService.saveMarketInfoList(marketInfoDtoList);
    }
}
