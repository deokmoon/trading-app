package com.trading.upbit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trading.upbit.domain.MarketBaseInformation;
import lombok.Data;
import lombok.Getter;

@Getter
public class InquiryAllMarketInformationDto {

    @JsonProperty("market")
    private String market;

    @JsonProperty("korean_name")
    private String koreanName;

    @JsonProperty("english_name")
    private String englishName;

    @JsonProperty("market_warning")
    private String marketWarning;

    public MarketBaseInformation toMarketBaseInformation() {
        return MarketBaseInformation.of(this.market, this.koreanName, this.englishName, this.marketWarning);
    }
}
