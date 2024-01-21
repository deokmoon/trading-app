package com.trading.domain.upbit.ticker.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// todo delete
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpbitCode {
    private String code;

}
