package com.trading.client.upbit.application;

import com.trading.upbit.ticker.adapter.MarketPriceInquiry;
import com.trading.upbit.ticker.domain.UpbitTicker;
import com.trading.upbit.ticker.domain.UpbitTickerStorage;
import com.trading.upbit.ticker.dto.InquiryPriceOrderBookDto;
import com.trading.upbit.ticker.dto.UpbitTickerResponseDto;
import com.trading.upbit.ticker.dto.mapper.UpbitTickerResponseDtoMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.trading.util.ConvertStringToDto.convertListDtoFromJson;

@Service
@RequiredArgsConstructor
public class UpbitService {
    // todo remove 필요
    private final MarketPriceInquiry marketPriceInquiry;

    public List<UpbitTickerResponseDto> getUpbitTickerPrice(String... markets) {
        List<UpbitTicker> upbitTicker = UpbitTickerStorage.getTicker(markets);
        UpbitTickerResponseDtoMapper mapper = Mappers.getMapper(UpbitTickerResponseDtoMapper.class);
        return mapper.map(upbitTicker);
    }

    public List<InquiryPriceOrderBookDto> getOrderBookPrice(String markets) {
        return convertListDtoFromJson(marketPriceInquiry.getStockOrderBook(markets).getBody(), InquiryPriceOrderBookDto.class);
    }

}
