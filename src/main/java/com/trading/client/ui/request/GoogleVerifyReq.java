package com.trading.client.ui.request;

import com.trading.client.application.auth.response.GoogleOAuthTokenRes;
import lombok.Getter;

@Getter
public class GoogleVerifyReq {

    private String idToken;

    public GoogleOAuthTokenRes toGoogleOAuthTokenRes() {
        return null;
    }

}
