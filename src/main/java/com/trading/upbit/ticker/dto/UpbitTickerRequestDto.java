package com.trading.upbit.ticker.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpbitTickerRequestDto {
    private String ticket;
    private String type;
    private List<String> codes;
    private String format;
    private boolean isOnlyRealtime;

    @Override
    public String toString() {
        return "[" +
                "{\"ticket\":\"" + ticket + "\"}," +
                "{\"type\":\"" + type + "\",\"codes\":" + codes + ",\"is_only_realtime\":\"" + isOnlyRealtime + "\"}," +
                "{\"format\":\"" + format + "\"}" +
                "]";
    }
}
