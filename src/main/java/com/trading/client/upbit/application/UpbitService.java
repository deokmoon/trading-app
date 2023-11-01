package com.trading.client.upbit.application;

import com.trading.upbit.ticker.dto.InquiryPriceOrderBookDto;
import com.trading.upbit.ticker.dto.InquiryPriceTickerDto;
import com.trading.upbit.ticker.adapter.MarketPriceInquiry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.trading.util.ConvertStringToDto.convertListDtoFromJson;

@Service
@RequiredArgsConstructor
public class UpbitService {
    // todo remove 필요
    private final MarketPriceInquiry marketPriceInquiry;

    public List<InquiryPriceTickerDto> getUpbitTickerPrice(String markets) {
        return convertListDtoFromJson(marketPriceInquiry.getStockTickerPrice(markets).getBody(), InquiryPriceTickerDto.class);
    }

    public List<InquiryPriceOrderBookDto> getOrderBookPrice(String markets) {
        return convertListDtoFromJson(marketPriceInquiry.getStockOrderBook(markets).getBody(), InquiryPriceOrderBookDto.class);
    }

}
