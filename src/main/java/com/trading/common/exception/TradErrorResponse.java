package com.trading.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trading.common.annotation.Description;
import com.trading.common.errorcode.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class TradErrorResponse {

//    @Description("에러 코드")
//    protected String code;

    @Description("에러 메시지")
    protected String message;

    @Description("상세 에러 메시지")
    protected String detailMessage;

    @Description("추가적인 에러 정보 목록")
    private List<Object> detail;

    public TradErrorResponse(ErrorCode ec) {
//        this.code = ec.getCode();
        this.message = ec.getMessage();
    }

    public TradErrorResponse(ErrorCode ec, List<Object> detail) {
        this(ec, null, detail);
    }

    public TradErrorResponse(ErrorCode ec, String detailMessage) {
        this(ec, detailMessage, null);
    }

    public TradErrorResponse(ErrorCode ec, String detailMessage, List<Object> detail) {
        this(ec.getCode(), ec.getMessage(), detailMessage, detail);
    }

    public TradErrorResponse(String code, String message, List<Object> detail) {
        this(code, message, null, detail);
    }

    public TradErrorResponse(String code, String message, String detailMessage, List<Object> detail) {
//        this.code = code;
        this.message = message;
        this.detailMessage = detailMessage;
        this.detail = detail;
    }

    public static ResponseEntity<TradErrorResponse> buildResponse(Throwable e, ErrorCode ec) {
        log.error(ec.getHttpStatus().toString(), e);

        return ResponseEntity
                .status(ec.getHttpStatus())
                .body(new TradErrorResponse(ec));
    }

    public static ResponseEntity<TradErrorResponse> buildResponse(Throwable e, ErrorCode ec, Object detail) {
        log.error(ec.getHttpStatus().toString(), e);

        TradErrorResponse errorResponse;

        if (detail instanceof List) {
            errorResponse = new TradErrorResponse(ec, (List) detail);
        } else {
            errorResponse = new TradErrorResponse(ec, Arrays.asList(detail));
        }
        return ResponseEntity
                .status(ec.getHttpStatus())
                .body(errorResponse);
    }

    public String convertToJson() throws JsonProcessingException {
        if (this == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JavaTimeModule());
//        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return mapper.writeValueAsString(this);
    }

}
