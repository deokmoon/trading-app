package com.trading.client.application.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenRes {
    private String refreshTokenKey;
    private String accessToken;
}
