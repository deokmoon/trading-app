package com.trading.remote.upbit.market.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trading.remote.upbit.market.domain.MarketBaseInformation;
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
