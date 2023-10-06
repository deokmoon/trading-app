package com.trading.client.dto;

import com.trading.upbit.domain.MarketBaseInformation;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class InquiryAllMarketInformationResponseDto {
    private String market;
    private String koreanName;
    private String englishName;
    private String marketWarning;

    private InquiryAllMarketInformationResponseDto(String market
            , String koreanName
            , String englishName
            , String marketWarning) {
        this.market = market;
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.marketWarning = marketWarning;
    }

    public static InquiryAllMarketInformationResponseDto from(MarketBaseInformation marketBaseInformation) {
        return new InquiryAllMarketInformationResponseDto(
                marketBaseInformation.getMarket()
                , marketBaseInformation.getKoreanName()
                , marketBaseInformation.getEnglishName()
                , marketBaseInformation.getMarketWarning()
        );
    }

    public static List<InquiryAllMarketInformationResponseDto> from(List<MarketBaseInformation> marketBaseInformation) {
        return marketBaseInformation.stream()
                .map(each -> from(each))
                .collect(Collectors.toList());
    }

}
