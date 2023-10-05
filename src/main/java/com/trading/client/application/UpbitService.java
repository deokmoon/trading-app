package com.trading.client.application;

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

    private final MarketPriceInquiry marketPriceInquiry;

    public List<InquiryPriceTickerDto> getUpbitTickerPrice(String markets) {
        return convertFromJson(marketPriceInquiry.getStockTickerPrice(markets).getBody(), InquiryPriceTickerDto.class);
    }

    public List<InquiryPriceOrderBookDto> getOrderBookPrice(String markets) {
        return convertFromJson(marketPriceInquiry.getStockOrderBook(markets).getBody(), InquiryPriceOrderBookDto.class);
    }
}
