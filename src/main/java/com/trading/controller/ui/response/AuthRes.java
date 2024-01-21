package com.trading.controller.ui.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthRes {

    private String authRes;

    public static AuthRes from(String string) {
        return AuthRes.builder()
                .authRes(string)
                .build();
    }
}



