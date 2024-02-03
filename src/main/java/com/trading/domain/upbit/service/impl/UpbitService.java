package com.trading.domain.upbit.service.impl;

import com.trading.controller.request.CandlesMinutesReq;
import com.trading.controller.response.CandlesMinutesRes;
import com.trading.domain.upbit.response.UpbitCandlesMinutesRes;
import com.trading.apiclient.upbit.CandlesInquiry;
import com.trading.apiclient.upbit.MarketPriceInquiry;
import com.trading.domain.upbit.ticker.domain.UpbitTicker;
import com.trading.domain.upbit.ticker.domain.UpbitTickerStorage;
import com.trading.domain.upbit.ticker.dto.InquiryPriceOrderBookDto;
import com.trading.domain.upbit.ticker.dto.UpbitTickerResponseDto;
import com.trading.domain.upbit.ticker.dto.mapper.UpbitTickerResponseDtoMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.trading.utils.ConvertStringToDto.convertListDtoFromJson;

@Service
@RequiredArgsConstructor
public class UpbitService {

    // todo remove 필요
    private final MarketPriceInquiry marketPriceInquiry;

    private final CandlesInquiry candlesInquiry;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public List<UpbitTickerResponseDto> getUpbitTickerPrice(String... markets) {
        List<UpbitTicker> upbitTicker = UpbitTickerStorage.getTicker(markets);
        UpbitTickerResponseDtoMapper mapper = Mappers.getMapper(UpbitTickerResponseDtoMapper.class);
        return mapper.map(upbitTicker);
    }

    public List<InquiryPriceOrderBookDto> getOrderBookPrice(String markets) {
        return convertListDtoFromJson(marketPriceInquiry.getStockOrderBook(markets).getBody(), InquiryPriceOrderBookDto.class);
    }

    /**
     * 분(Minute) 캔들
     */
    // TODO @Cacheable 처리 필요
    public CandlesMinutesRes getCandlesMinutes(String unit, CandlesMinutesReq req) {
        List<UpbitCandlesMinutesRes> upbitCandlesMinutesRes = candlesInquiry.getCandlesMinutes(unit, req.getMarket(), req.getTo().format(formatter), req.getCount());
        return CandlesMinutesRes.from(upbitCandlesMinutesRes);
    }

}
