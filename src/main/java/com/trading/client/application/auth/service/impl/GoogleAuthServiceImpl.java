package com.trading.client.application.auth.service.impl;

import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.auth.oauth2.TokenVerifier;
import com.trading.client.application.auth.service.GoogleAuthService;
import com.trading.client.application.auth.response.GoogleUserRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// https://github.com/googleapis/google-auth-library-java
@Service
@Slf4j
public class GoogleAuthServiceImpl implements GoogleAuthService {

    @Value("${google.client-id}")
    private String clientId;

    // TODO 개선
    @Override
    public GoogleUserRes requestUserInfo(String idToken) {

        TokenVerifier tokenVerifier = TokenVerifier.newBuilder()
                .setAudience(clientId)
                .build();

        try {
            JsonWebSignature jsonWebSignature = tokenVerifier.verify(idToken);
            log.info("jsonWebSignature = " + jsonWebSignature);
            // optionally verify additional claims
            if (!"expected-value".equals(jsonWebSignature.getPayload().get("additional-claim"))) {
                // handle custom verification error
            }
            return GoogleUserRes.from(jsonWebSignature.getPayload());
        } catch (TokenVerifier.VerificationException e) {
            // invalid token
            log.info("e = " + e);
        }
        return null;
    }

}
