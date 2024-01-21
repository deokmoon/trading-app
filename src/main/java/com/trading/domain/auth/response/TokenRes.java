package com.trading.domain.auth.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenRes {
    private String refreshTokenKey;
    private String accessToken;
}
