package com.trading.upbit.market.application;

import com.trading.upbit.market.dto.InquiryAllMarketInformationDto;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.trading.constant.FileWriteConstants.JSON_FORMAT;
import static com.trading.constant.FileWriteConstants.JSON_RESPONSE_DIRECTORY;
import static com.trading.constant.FileWriteConstants.UPBIT_MARKET_MASTER_FILE_NAME;
import static com.trading.util.JsonFileWriter.writeJsonFile;

@Service
public class MarketPriceService {

    public void createMarketInfoJsonFile(List<InquiryAllMarketInformationDto> marketInfoDtoList) {
        String filePath = JSON_RESPONSE_DIRECTORY + UPBIT_MARKET_MASTER_FILE_NAME + JSON_FORMAT;
        writeJsonFile(marketInfoDtoList, filePath);
    }
}
