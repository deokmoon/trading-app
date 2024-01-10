package com.trading.client.application.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReissueAccessTokenRes {

    private String accessToken;

    public static ReissueAccessTokenRes from(String accessToken) {
        return ReissueAccessTokenRes.builder()
                .accessToken(accessToken)
                .build();
    }

}
