package com.trading.upbit.application;

import com.trading.upbit.domain.MarketBaseInformationRepository;
import com.trading.upbit.dto.InquiryAllMarketInformationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MarketPriceService {

    private final MarketBaseInformationRepository marketBaseInformationRepository;

    public void saveMarketInfoList(List<InquiryAllMarketInformationDto> marketInfoDtoList) {
        marketInfoDtoList.forEach(eachMarketInfo -> {
            marketBaseInformationRepository.save(eachMarketInfo.toMarketBaseInformation());
        });
    }
}
