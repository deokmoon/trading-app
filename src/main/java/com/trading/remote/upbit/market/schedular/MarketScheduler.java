package com.trading.remote.upbit.market.schedular;

import com.trading.remote.upbit.market.application.MarketBaseService;
import com.trading.remote.upbit.market.dto.InquiryAllMarketInformationDto;
import com.trading.remote.upbit.market.feign.MarketCodeInquiry;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.trading.util.ConvertStringToDto.convertListDtoFromJson;

@Component
@RequiredArgsConstructor
public class MarketScheduler {
    private final MarketBaseService marketBaseService;
    private final MarketCodeInquiry marketCodeInquiry;

    @Scheduled(fixedDelayString = "${schedule.fixed.delay.upbit}")
    public void retrieveAndSaveTicker() {
        // 전체 종목 조회
        List<InquiryAllMarketInformationDto> marketInfoDtoList = convertListDtoFromJson(marketCodeInquiry.getAllMarketInformation().getBody(), InquiryAllMarketInformationDto.class);
        marketBaseService.createMarketInfoJsonFile(marketInfoDtoList);
        marketBaseService.saveMarketBase(marketInfoDtoList);
    }
}
