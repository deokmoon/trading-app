package com.trading.client.ui;

import com.trading.client.application.auth.service.AuthService;
import com.trading.client.application.response.FindPasswordAuthRes;
import com.trading.client.application.response.ReissueAccessTokenRes;
import com.trading.client.ui.request.CheckDuplEmailReq;
import com.trading.client.ui.request.FindPasswordReq;
import com.trading.client.ui.request.GoogleVerifyReq;
import com.trading.client.ui.request.LoginReq;
import com.trading.client.ui.request.LogoutReq;
import com.trading.client.ui.request.ReissueAccessTokenReq;
import com.trading.client.ui.request.ResetPasswordReq;
import com.trading.client.ui.request.SignupReq;
import com.trading.client.ui.response.CheckDuplEmailRes;
import com.trading.client.ui.response.EmailAuthRes;
import com.trading.client.ui.response.InitDateRes;
import com.trading.client.ui.response.LoginRes;
import com.trading.client.ui.response.LogoutRes;
import com.trading.client.ui.response.SignupRes;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${spring.mail.username}")
    private String emailUser;

    @Value("${myprofile}")
    private String myprofile;

    private final AuthService authService;

    @GetMapping("/index")
    public String getAuth() {
        return "Auth!" + myprofile;
    }

    /**
     * Appkey 발행하기
     */
    @GetMapping("/appkey")
    public String getAppkey(HttpServletResponse response) {
        Cookie cookie = authService.getAppKey();
        response.addCookie(cookie);
        return "check cookie";
    }

    /**
     * 초기데이터를 조회하기
     */
    @GetMapping("/initdata")
    public InitDateRes getInitData(HttpServletResponse response) {
        Cookie cookie = authService.getAppKey();
        response.addCookie(cookie);
        return new InitDateRes(emailUser);
    }


    /**
     * 이메일주소 중복 체크하기
     */
    @GetMapping("/check-dupl-email")
    public CheckDuplEmailRes checkDuplEmail(@Valid @ModelAttribute CheckDuplEmailReq req) {
        CheckDuplEmailRes checkDuplEmailRes = authService.checkDuplEmail(req);
        return checkDuplEmailRes;
    }

    /**
     * 회원가입하기
     */
    @PostMapping("/signup")
    public SignupRes signup(@Valid @RequestBody SignupReq signupReq) {
        SignupRes signupRes = authService.signup(signupReq);
        return signupRes;
    }

    /**
     * 이메일 인증하기
     */
    @GetMapping("/email/{userId}/{authKey}")
    public EmailAuthRes emailAuth(@Valid @PathVariable String userId, @PathVariable String authKey) {
        EmailAuthRes emailAuthRes = authService.emailAuth(userId, authKey);
        return emailAuthRes;
    }

    /**
     * 로그인하기
     */
    @PostMapping("/login")
    public LoginRes login(@Valid @RequestBody LoginReq loginReq) {
        LoginRes loginRes = authService.login(loginReq);
        return loginRes;
    }

    /**
     * 로그아웃하기
     */
    @PostMapping("/logout")
    public LogoutRes logout(@Valid @RequestBody LogoutReq logoutReq) {
        LogoutRes logoutRes = authService.logout(logoutReq);
        return logoutRes;
    }

    /**
     * 비밀번호 초기화 이메일 발송하기
     */
    @PostMapping("/password/find")
    public String findPassword(@RequestBody FindPasswordReq req) {
        authService.findPassword(req);
        return "Email is Sent";
    }

    /**
     * 비밀번호 초기화 URL 검증
     */
    @Deprecated(forRemoval = true)
    @GetMapping("/password/find/{userId}/{authKey}")
    public FindPasswordAuthRes findPasswordAuth(@PathVariable String userId, @PathVariable String authKey) {
        FindPasswordAuthRes findPasswordAuthRes = authService.findPasswordAuth(userId, authKey);
        return findPasswordAuthRes;
    }

    /**
     * 비밀번호 초기화하기
     */
    @PostMapping("/password/reset")
    public String resetPassword(@RequestBody ResetPasswordReq req) {
        String userId = authService.resetPassword(req);
        return userId;
    }

    /**
     * accessToken 을 재발행한다.
     */
    @PostMapping("/reissue-access-token")
    public ReissueAccessTokenRes reissueAccessToken(@RequestBody ReissueAccessTokenReq req) {
        ReissueAccessTokenRes reissueAccessTokenRes = authService.reissueAccessToken(req);
        return reissueAccessTokenRes;
    }

    /**
     * google idToken 을 검증하고, 로그인처리한다.
     */
    @PostMapping("/google/verify")
    public LoginRes verifyGoogle(@RequestBody GoogleVerifyReq googleVerifyReq) {
        LoginRes loginRes = authService.verifyGoogle(googleVerifyReq);
        return loginRes;
    }

    /**
     * TODO apple 로그인을 인증한다
     */

}
