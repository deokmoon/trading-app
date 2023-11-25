package com.trading.remote.upbit.market.application;

import com.trading.remote.upbit.market.domain.MarketBaseStorage;
import com.trading.remote.upbit.market.dto.InquiryAllMarketInformationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.trading.constant.FileWriteConstants.JSON_FORMAT;
import static com.trading.constant.FileWriteConstants.JSON_RESPONSE_DIRECTORY;
import static com.trading.constant.FileWriteConstants.UPBIT_MARKET_MASTER_FILE_NAME;
import static com.trading.util.JsonFileWriter.writeJsonFile;

@RequiredArgsConstructor
@Service
public class MarketBaseService {

    private final MarketBaseStorage marketBaseStorage;

    public void createMarketInfoJsonFile(List<InquiryAllMarketInformationDto> marketInfoDtoList) {
        String filePath = JSON_RESPONSE_DIRECTORY + UPBIT_MARKET_MASTER_FILE_NAME + JSON_FORMAT;
        writeJsonFile(marketInfoDtoList, filePath);
    }

    public void saveMarketBase(List<InquiryAllMarketInformationDto> marketInfoDtoList) {
        for (InquiryAllMarketInformationDto marketInformationDto : marketInfoDtoList) {
            marketBaseStorage.save(marketInformationDto.toMarketBaseInformation());
        }
    }
}
