package com.trading.upbit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InquiryPriceOrderBookUnitDto {
    @JsonProperty("ask_price")
    private double askPrice;

    @JsonProperty("bid_price")
    private double bidPrice;

    @JsonProperty("ask_size")
    private double askSize;

    @JsonProperty("bid_size")
    private double bidSize;
}
