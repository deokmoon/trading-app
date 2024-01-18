package com.trading.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Slf4j
@RestControllerAdvice
public class TradRequestBodyAdvice extends RequestBodyAdviceAdapter {

    @Override
    public boolean supports(final MethodParameter methodParameter, final Type targetType, final Class<? extends HttpMessageConverter<?>> converterType) {
        log.info("RequestBodyAdvice:supports");
        Class cls = methodParameter.getParameterType();

        // 컬렉션일 경우에 대한 처리
        if (targetType instanceof ParameterizedType) {
            cls = (Class) ((ParameterizedType) targetType).getActualTypeArguments()[0];
        }
//        return HntBaseRequest.class.isAssignableFrom(cls) == false;
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(final HttpInputMessage inputMessage, final MethodParameter parameter, final Type targetType, final Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        log.info("RequestBodyAdvice:beforeBodyRead");
        return super.beforeBodyRead(inputMessage, parameter, targetType, converterType);
    }

}
