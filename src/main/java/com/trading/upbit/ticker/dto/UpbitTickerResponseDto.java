package com.trading.upbit.ticker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpbitTickerResponseDto {
    @JsonProperty("type")
    private String type;

    @JsonProperty("code")
    private String code;

    @JsonProperty("opening_price")
    private String openingPrice;

    @JsonProperty("high_price")
    private String highPrice;

    @JsonProperty("low_price")
    private String lowPrice;

    @JsonProperty("trade_price")
    private String tradePrice;

    @JsonProperty("prev_closing_price")
    private String prevClosingPrice;

    @JsonProperty("acc_trade_price")
    private String accTradePrice;

    @JsonProperty("change")
    private String change;

    @JsonProperty("change_price")
    private String changePrice;

    @JsonProperty("signed_change_price")
    private String signedChangePrice;

    @JsonProperty("change_rate")
    private String changeRate;

    @JsonProperty("signed_change_rate")
    private String signedChangeRate;

    @JsonProperty("ask_bid")
    private String askBid;

    @JsonProperty("trade_volume")
    private String tradeVolume;

    @JsonProperty("acc_trade_volume")
    private String accTradeVolume;

    @JsonProperty("trade_date")
    private String tradeDate;

    @JsonProperty("trade_time")
    private String tradeTime;

    @JsonProperty("trade_timestamp")
    private long tradeTimestamp;

    @JsonProperty("acc_ask_volume")
    private String accAskVolume;

    @JsonProperty("acc_bid_volume")
    private String accBidVolume;

    @JsonProperty("highest_52_week_price")
    private String highest52WeekPrice;

    @JsonProperty("highest_52_week_date")
    private String highest52WeekDate;

    @JsonProperty("lowest_52_week_price")
    private String lowest52WeekPrice;

    @JsonProperty("lowest_52_week_date")
    private String lowest52WeekDate;

    @JsonProperty("market_state")
    private String marketState;

    @JsonProperty("is_trading_suspended")
    private boolean isTradingSuspended;

    @JsonProperty("delisting_date")
    private String delistingDate;

    @JsonProperty("market_warning")
    private String marketWarning;

    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("acc_trade_price_24h")
    private String accTradePrice24h;

    @JsonProperty("acc_trade_volume_24h")
    private String accTradeVolume24h;

    @JsonProperty("stream_type")
    private String streamType;
}
