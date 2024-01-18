package com.trading.client.application;


import com.trading.client.application.response.GoogleUserRes;

public interface GoogleAuthService {

    GoogleUserRes requestUserInfo(String idToken);

}
