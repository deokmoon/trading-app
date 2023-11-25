package com.trading.remote.upbit.ticker.domain;

import lombok.Data;

@Data
public class UpbitTicker {

    private String type;
    private String code;
    private String openingPrice;
    private String highPrice;
    private String lowPrice;
    private String tradePrice;
    private String prevClosingPrice;
    private String accTradePrice;
    private String change;
    private String changePrice;
    private String signedChangePrice;
    private String changeRate;
    private String signedChangeRate;
    private String askBid;
    private String tradeVolume;
    private String accTradeVolume;
    private String tradeDate;
    private String tradeTime;
    private long tradeTimestamp;
    private String accAskVolume;
    private String accBidVolume;
    private String highest52WeekPrice;
    private String highest52WeekDate;
    private String lowest52WeekPrice;
    private String lowest52WeekDate;
    private String marketState;
    private boolean isTradingSuspended;
    private String delistingDate;
    private String marketWarning;
    private long timestamp;
    private String accTradePrice24h;
    private String accTradeVolume24h;
    private String streamType;
}
