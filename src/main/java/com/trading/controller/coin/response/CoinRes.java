package com.trading.controller.coin.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Getter
public class CoinRes {

    public static CoinRes from() {
        return CoinRes.builder().build();
    }

}
