package com.trading.config.filter;

import com.trading.common.errorcode.AppKeyFilterErrorCode;
import com.trading.common.exception.TradRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
@Order(20)
public class AppKeyFilter extends OncePerRequestFilter {

    @Value("${app-key}")
    private String appKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("AppKeyFilter:doFilterInternal");
        String uri = request.getRequestURI();
        Pattern pattern = Pattern.compile("/(auth/(index|initdata|appkey|email|password|check-dupl-email|signup|logout|google/verify))");
        Matcher mat = pattern.matcher(uri);
        if (mat.find()) {
            // 패턴에 일치하면 appKey 체크없이 통과
            filterChain.doFilter(request, response);
        } else {
            if (Objects.isNull(request.getCookies())) {
                // 401 appkey must be included or is wrong
                throw new TradRuntimeException(AppKeyFilterErrorCode.NO_APPKEY);
            }
            List<Cookie> cookieList = Arrays.stream(request.getCookies()).filter(c -> Objects.equals("x_appkey", c.getName())).collect(Collectors.toList());
            System.out.println(cookieList);
            if (cookieList.size() == 0) {
                // 401 appkey must be included or is wrong
                throw new TradRuntimeException(AppKeyFilterErrorCode.NO_APPKEY);
            }
            Cookie cookie = cookieList.get(0);
            System.out.printf("AppKeyFilter:doFilterInternal:cookie.getValue() {}", cookie.getValue());
            if (cookie == null || !appKey.equals(cookie.getValue())) {
                // 401 appkey must be included or is wrong
                throw new TradRuntimeException(AppKeyFilterErrorCode.NO_APPKEY);
            }
            filterChain.doFilter(request, response);
        }
    }

}
