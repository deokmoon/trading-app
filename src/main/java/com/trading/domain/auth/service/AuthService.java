package com.trading.domain.auth.service;

import com.trading.domain.auth.response.FindPasswordAuthRes;
import com.trading.domain.auth.response.ReissueAccessTokenRes;
import com.trading.controller.request.EmailStatusReq;
import com.trading.controller.request.EmailAuthReq;
import com.trading.controller.request.FindPasswordAuthReq;
import com.trading.controller.request.FindPasswordReq;
import com.trading.controller.request.GoogleVerifyReq;
import com.trading.controller.request.LoginReq;
import com.trading.controller.request.LogoutReq;
import com.trading.controller.request.ReissueAccessTokenReq;
import com.trading.controller.request.ResetPasswordReq;
import com.trading.controller.request.SignupReq;
import com.trading.controller.response.EmailStatusRes;
import com.trading.controller.response.EmailAuthRes;
import com.trading.controller.response.LoginRes;
import com.trading.controller.response.LogoutRes;
import com.trading.controller.response.SignupRes;
import jakarta.servlet.http.Cookie;

public interface AuthService {

    Cookie getAppKey();

    EmailStatusRes checkEmailStatus(EmailStatusReq req);

    SignupRes signup(SignupReq signupReq);

    EmailAuthRes emailAuth(EmailAuthReq emailAuthReq);

    LoginRes login(LoginReq loginReq);

    LogoutRes logout(LogoutReq logoutReq);

    void findPassword(FindPasswordReq req);

    FindPasswordAuthRes findPasswordAuth(FindPasswordAuthReq findPasswordAuthReq);

    String resetPassword(ResetPasswordReq req);

    ReissueAccessTokenRes reissueAccessToken(ReissueAccessTokenReq req);

    LoginRes verifyGoogle(GoogleVerifyReq googleVerifyReq);

    // TODO verifyApple
}
