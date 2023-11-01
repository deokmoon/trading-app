package com.trading.upbit.ticker.domain;

import lombok.Getter;

@Getter
public class UpbitTicker {
    private String type;
    private String code;
    private double openingPrice;
    private double highPrice;
    private double lowPrice;
    private double tradePrice;
    private double prevClosingPrice;
    private double accTradePrice;
    private String change;
    private double changePrice;
    private double signedChangePrice;
    private double changeRate;
    private double signedChangeRate;
    private String askBid;
    private double tradeVolume;
    private double accTradeVolume;
    private String tradeDate;
    private String tradeTime;
    private long tradeTimestamp;
    private double accAskVolume;
    private double accBidVolume;
    private double highest52WeekPrice;
    private String highest52WeekDate;
    private double lowest52WeekPrice;
    private String lowest52WeekDate;
    private String marketState;
    private boolean isTradingSuspended;
    private String delistingDate;
    private String marketWarning;
    private long timestamp;
    private double accTradePrice24h;
    private double accTradeVolume24h;
    private String streamType;
}
