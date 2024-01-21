package com.trading.config.filter;

import com.trading.domain.auth.utils.JwtUtils;
import com.trading.common.errorcode.JwtAuthenticationFilterErrorCode;
import com.trading.common.exception.TradRuntimeException;
import com.trading.domain.user.User;
import com.trading.domain.user.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
@RequiredArgsConstructor
@Order(30)
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.secret-key}")
    private String secretKey;

    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("JwtAuthenticationFilter:doFilterInternal");
        String uri = request.getRequestURI();
        // TODO AppkeyFilter 의 doFilterInter 과 패턴체크가 일부 중복 "/(auth|weather|news|corona|docs)" 로?
        Pattern pattern = Pattern.compile("/(auth/(index|login|initdata|appkey|email|password|check-dupl-email|signup|logout|google/verify)|weather|news|corona|docs)");
//        Pattern pattern = Pattern.compile("/auth/login");
        Matcher mat = pattern.matcher(uri);
        if (mat.find()) {
            // 패턴에 일치하면 access_token 체크없이 통과
            filterChain.doFilter(request, response);
            return;
        }

        String authorization = request.getHeader("Authorization");
        if ("GET" .equals(request.getMethod()) && uri.indexOf("/app-version") > -1) {
            // 요청 URL 이 GET /app-version 이면 -> ATK 체크 예외
            filterChain.doFilter(request, response);
            return;
        }

        if (ObjectUtils.isEmpty(authorization)) {
            // access_token 이 없으면 401
            throw new TradRuntimeException(JwtAuthenticationFilterErrorCode.INVALID);
        }

        String token = authorization.split(" ")[1];
        Jws<Claims> claimsJws = null;
        try {
            claimsJws = JwtUtils.parseToken(token, secretKey);
        } catch (Exception e) {
            if (e.toString().indexOf("jwt expired") > 0) {
                // Reissue access token
                throw new TradRuntimeException(JwtAuthenticationFilterErrorCode.REISSUE);
            }
            // access token is invalid
            throw new TradRuntimeException(JwtAuthenticationFilterErrorCode.INVALID);
        }

        LocalDateTime now = LocalDateTime.now();
        long nowEpochSecond = now.atZone(ZoneId.systemDefault()).toEpochSecond();
        Claims body = claimsJws.getBody();
        long exp = ((Number) body.get("exp")).longValue();

        if (nowEpochSecond > exp - 20 * 60) {
            // 현재 시간이 만료시간으로부터 20분이 안남았으면 재발행 필요 응답을 보냄
            throw new TradRuntimeException(JwtAuthenticationFilterErrorCode.REISSUE);
        }
        String userId = (String) body.get("userId");
        User user = userService.getUserByUserId(userId);
        if (ObjectUtils.isEmpty(user)) {
            // 로그인한 사용자가 없음
            throw new TradRuntimeException(JwtAuthenticationFilterErrorCode.USER_NOT_FOUND);
        }
        // request 에 로그인한 사용자 저장
        request.setAttribute("user", user);
        filterChain.doFilter(request, response);
    }

}
