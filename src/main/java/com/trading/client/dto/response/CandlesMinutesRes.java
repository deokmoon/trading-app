package com.trading.client.dto.response;

import com.trading.upbit.dto.response.UpbitCandlesMinutesRes;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CandlesMinutesRes {

    List<UpbitCandlesMinutesRes> list;

    public static CandlesMinutesRes from(List<UpbitCandlesMinutesRes> upbitCandlesMinutesRes) {
        return CandlesMinutesRes.builder()
                .list(upbitCandlesMinutesRes)
                .build();
    }
    /*
        "market": "KRW-BTC",
        "candle_date_time_utc": "2023-01-02T01:59:00",
        "candle_date_time_kst": "2023-01-02T10:59:00",
        "opening_price": 21135000.00000000,
        "high_price": 21145000.00000000,
        "low_price": 21134000.00000000,
        "trade_price": 21143000.00000000,
        "timestamp": 1672624797692,
        "candle_acc_trade_price": 88613365.31486000,
        "candle_acc_trade_volume": 4.19213632,
        "unit": 1
     */
}
