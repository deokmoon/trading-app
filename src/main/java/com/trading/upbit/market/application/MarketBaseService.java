package com.trading.upbit.market.application;

import com.trading.upbit.market.domain.MarketBaseStorage;
import com.trading.upbit.market.domain.repository.MarketBaseRepository;
import com.trading.upbit.market.dto.InquiryAllMarketInformationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.trading.common.constants.FileWriteConstants.JSON_FORMAT;
import static com.trading.common.constants.FileWriteConstants.JSON_RESPONSE_DIRECTORY;
import static com.trading.common.constants.FileWriteConstants.UPBIT_MARKET_MASTER_FILE_NAME;
import static com.trading.util.JsonFileWriter.writeJsonFile;

@RequiredArgsConstructor
@Service
public class MarketBaseService {

    private final MarketBaseStorage marketBaseStorage;
    private final MarketBaseRepository marketBaseRepository;

    public void createMarketInfoJsonFile(List<InquiryAllMarketInformationDto> marketInfoDtoList) {
        String filePath = JSON_RESPONSE_DIRECTORY + UPBIT_MARKET_MASTER_FILE_NAME + JSON_FORMAT;
        writeJsonFile(marketInfoDtoList, filePath);
    }

    public void saveMarketBase(List<InquiryAllMarketInformationDto> marketInfoDtoList) {
        for (InquiryAllMarketInformationDto marketInformationDto : marketInfoDtoList) {
//            marketBaseStorage.save(marketInformationDto.toMarketBaseInformation());
            marketBaseStorage.save(marketInformationDto.toMarketBaseInformation());
        }
    }
}
