package com.trading.common.exception;

import com.trading.common.errorcode.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Order(100)
@RestControllerAdvice
public class TradExceptionHandler {

    @ExceptionHandler(TradRuntimeException.class)
    public ResponseEntity<TradErrorResponse> handleException(TradRuntimeException e) {
        log.info("DrtdExceptionHandler:handleException");
        StringBuilder logMsg = new StringBuilder();

        logMsg.append("message: ");
        logMsg.append(e.getMessage());

        if (StringUtils.hasText(e.getDetailMessage())) {
            logMsg.append("\ndetailMessage: ");
            logMsg.append(e.getDetailMessage());
        }

        if (CollectionUtils.isEmpty(e.getDetail()) == false) {
            logMsg.append("\ndetail: ");
            logMsg.append(e.getDetail());
        }

        /**
         * CHECK
         * 사용자가 없으면 DrtdExceptionHandler 발생
         * -> Error 로 로그찍힘
         * 하지만 사용자가 없다는건 Error 요소는 아님
         * stacktrace 가 찍혀야 하나?
         */
        // stacktrace 포함 로깅
        log.error(logMsg.toString(), e);

        ErrorCode ec = e.getErrorCode();

        return ResponseEntity
                .status(ec.getHttpStatus())
                .body(new TradErrorResponse(ec, e.getDetailMessage(), e.getDetail()));
    }

}
