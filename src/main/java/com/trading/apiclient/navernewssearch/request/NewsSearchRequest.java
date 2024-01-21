package com.trading.apiclient.navernewssearch.request;

import com.trading.apiclient.navernewssearch.constants.NaverKakaoConstant;
import com.trading.apiclient.navernewssearch.constants.Sort;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NewsSearchRequest {

    @NotBlank(message = NaverKakaoConstant.ERROR_MSG_NO_KEYWORD)
    private String query;

    private Sort sort;

    @Min(value = NaverKakaoConstant.MIN_REQUEST_PAGE, message = NaverKakaoConstant.ERROR_MSG_PAGE_UNDER_MIN_VALUE)
    @Max(value = NaverKakaoConstant.MAX_REQUEST_PAGE, message = NaverKakaoConstant.ERROR_MSG_PAGE_OVER_MAX_VALUE)
    private Integer start;

    @Min(value = NaverKakaoConstant.MIN_REQUEST_SIZE, message = NaverKakaoConstant.ERROR_MSG_SIZE_UNDER_MIN_VALUE)
    @Max(value = NaverKakaoConstant.MAX_REQUEST_SIZE, message = NaverKakaoConstant.ERROR_MSG_SIZE_OVER_MAX_VALUE)
    private Integer display;

    public NewsSearchRequest(String query, Sort sort, Integer start, Integer display) {
        this.query = query;
        this.sort = sort == null ? Sort.ACCURACY : sort;
        this.start = start == null ? NaverKakaoConstant.DEFAULT_PAGE : start;
        this.display = display == null ? NaverKakaoConstant.DEFAULT_SIZE : display;
    }
}
