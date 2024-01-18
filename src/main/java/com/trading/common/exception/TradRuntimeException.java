package com.trading.common.exception;

import com.trading.common.errorcode.ErrorCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class TradRuntimeException extends RuntimeException {

    protected final ErrorCode errorCode;

    protected String detailMessage;

    protected List<Object> detail;

    public TradRuntimeException(ErrorCode errorCode, Object detail) {
        this(errorCode, null, detail);
    }

    public TradRuntimeException(ErrorCode errorCode, String detailMessage, Object detail) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.detailMessage = detailMessage;

        if (detail == null) return;

        if (detail instanceof List) {
            this.detail = (List) detail;
        } else {
            this.detail = Arrays.asList(detail);
        }
    }

    public TradRuntimeException(final ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
