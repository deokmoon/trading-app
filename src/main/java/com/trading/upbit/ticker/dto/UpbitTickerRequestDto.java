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
    private List<UpbitCode> codes;
    private String format;
}
