package com.trading.config.aop;

import com.trading.common.annotation.IgnoreTradApiResponse;
import com.trading.config.model.TradApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@RestControllerAdvice
public class TradResponseBodyAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(final MethodParameter returnType, final Class converterType) {
        log.info("TradResponseBodyAdvice:supports");
        if (returnType.getMethodAnnotation(IgnoreTradApiResponse.class) != null ||
                returnType.getExecutable().getDeclaringClass().getAnnotation(IgnoreTradApiResponse.class) != null) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(final Object body,
                                  final MethodParameter returnType,
                                  final MediaType selectedContentType,
                                  final Class selectedConverterType,
                                  final ServerHttpRequest request,
                                  final ServerHttpResponse response) {
        log.info("TradResponseBodyAdvice:beforeBodyWrite:body", body);
        return new TradApiResponse("Success", body);
    }

}
