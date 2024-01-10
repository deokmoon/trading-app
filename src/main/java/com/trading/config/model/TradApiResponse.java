package com.trading.config.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TradApiResponse<T> {
    private String message;
//    private String logKey;
    private T result;

    public TradApiResponse(String message, T result) {
        this.message = message;
//        this.logKey = logKey;
        this.result = result;
    }

}
