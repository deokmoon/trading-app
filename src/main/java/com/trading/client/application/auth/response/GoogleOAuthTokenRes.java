package com.trading.client.application.auth.response;

import lombok.Getter;

@Getter
public class GoogleOAuthTokenRes {

    private String access_token;

    private int expires_in;

    private String scope;

    private String token_type;

    private String id_token;

}
