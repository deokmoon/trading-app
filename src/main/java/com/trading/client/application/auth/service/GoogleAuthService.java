package com.trading.client.application.auth.service;


import com.trading.client.application.auth.response.GoogleUserRes;

public interface GoogleAuthService {

    GoogleUserRes requestUserInfo(String idToken);

}
