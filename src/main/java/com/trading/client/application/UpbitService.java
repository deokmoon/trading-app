package com.trading.client.application;

import com.trading.client.dto.InquiryAllMarketInformationResponseDto;
import com.trading.upbit.domain.MarketBaseInformationRepository;
import com.trading.upbit.dto.InquiryPriceOrderBookDto;
import com.trading.upbit.dto.InquiryPriceTickerDto;
import com.trading.upbit.feignClient.MarketPriceInquiry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.trading.util.ConvertStringToDto.convertFromJson;

@Service
@RequiredArgsConstructor
public class UpbitService {
    // todo remove 필요
    private final MarketPriceInquiry marketPriceInquiry;
    private final MarketBaseInformationRepository marketBaseInformationRepository;

    public List<InquiryPriceTickerDto> getUpbitTickerPrice(String markets) {
        return convertFromJson(marketPriceInquiry.getStockTickerPrice(markets).getBody(), InquiryPriceTickerDto.class);
    }

    public List<InquiryPriceOrderBookDto> getOrderBookPrice(String markets) {
        return convertFromJson(marketPriceInquiry.getStockOrderBook(markets).getBody(), InquiryPriceOrderBookDto.class);
    }

    public List<InquiryAllMarketInformationResponseDto> getMarketInformationList() {
        return InquiryAllMarketInformationResponseDto.from(marketBaseInformationRepository.findAll());
    }
}
