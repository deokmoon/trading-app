package com.trading.upbit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class InquiryPriceOrderBookDto {
    @JsonProperty("market")
    private String market;

    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("total_ask_size")
    private double totalAskSize;

    @JsonProperty("total_bid_size")
    private double totalBidSize;

    @JsonProperty("orderbook_units")
    private List<InquiryPriceOrderBookUnitDto> orderBookUnits;
}
