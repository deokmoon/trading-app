package com.trading.config.filter;

import com.trading.common.errorcode.ErrorCode;
import com.trading.common.exception.TradErrorResponse;
import com.trading.common.exception.TradRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@Order(10)
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("ExceptionHandlerFilter:doFilterInternal");
        try {
            filterChain.doFilter(request, response);
        } catch (TradRuntimeException e) {
            StringBuilder logMsg = getLogMsg(e);
            log.error(logMsg.toString(), e);
            setResponse(response, e);
        }
    }

    private void setResponse(HttpServletResponse response, TradRuntimeException e) throws IOException {
        response.setStatus(e.getErrorCode().getHttpStatus().value());
        response.setContentType("application/json");
        ErrorCode ec = e.getErrorCode();
        TradErrorResponse tradErrorResponse = new TradErrorResponse(ec, e.getDetailMessage(), e.getDetail());

        response.getWriter().write(tradErrorResponse.convertToJson());
    }

    private static StringBuilder getLogMsg(TradRuntimeException e) {
        StringBuilder logMsg = new StringBuilder();

        logMsg.append("message: ").append(e.getMessage());

        if (StringUtils.hasText(e.getDetailMessage())) {
            logMsg.append("\ndetailMessage: ").append(e.getDetailMessage());
        }

        if (CollectionUtils.isEmpty(e.getDetail()) == false) {
            logMsg.append("\ndetail: ").append(e.getDetail());
        }
        return logMsg;
    }

}
