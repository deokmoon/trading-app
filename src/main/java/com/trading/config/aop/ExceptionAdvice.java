package com.trading.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.FailedLoginException;
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleLoginException(FailedLoginException e) {
        log.error("Login Exception({}) - {}", e.getClass().getSimpleName(), e.getMessage());
        return e.getMessage();
    }
}
