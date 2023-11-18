package com.trading.client.application;

import com.trading.client.dto.InquiryAllMarketInformationResponseDto;
import com.trading.client.dto.requests.CandlesMinutesReq;
import com.trading.client.dto.response.CandlesMinutesRes;
import com.trading.upbit.domain.MarketBaseInformationRepository;
import com.trading.upbit.dto.InquiryPriceOrderBookDto;
import com.trading.upbit.dto.InquiryPriceTickerDto;
import com.trading.upbit.dto.response.UpbitCandlesMinutesRes;
import com.trading.upbit.feignClient.CandlesInquiry;
import com.trading.upbit.feignClient.MarketPriceInquiry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import static com.trading.util.ConvertStringToDto.convertFromJson;

@Service
@RequiredArgsConstructor
public class UpbitService {

    // todo remove 필요
    private final MarketPriceInquiry marketPriceInquiry;

    private final CandlesInquiry candlesInquiry;

    private final MarketBaseInformationRepository marketBaseInformationRepository;

    private static final String DATE_FORMATTER = "yyyy-MM-dd'T'HH:mm:ss";

    public List<InquiryPriceTickerDto> getUpbitTickerPrice(String markets) {
        return convertFromJson(marketPriceInquiry.getStockTickerPrice(markets).getBody(), InquiryPriceTickerDto.class);
    }

    public List<InquiryPriceOrderBookDto> getOrderBookPrice(String markets) {
        return convertFromJson(marketPriceInquiry.getStockOrderBook(markets).getBody(), InquiryPriceOrderBookDto.class);
    }

    public List<InquiryAllMarketInformationResponseDto> getMarketInformationList() {
        return InquiryAllMarketInformationResponseDto.from(marketBaseInformationRepository.findAll());
    }

    /**
     * 분(Minute) 캔들
     */
    public CandlesMinutesRes getCandlesMinutes(CandlesMinutesReq req) {
        String to = "";
        if (Objects.isNull(req.getTo()) == false) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
            to = req.getTo().format(formatter);
        }
        List<UpbitCandlesMinutesRes> upbitCandlesMinutesRes = candlesInquiry.getCandlesMinutes(req.getUnit(), req.getMarket(), to, req.getCount());
        return CandlesMinutesRes.from(upbitCandlesMinutesRes);
    }

}
