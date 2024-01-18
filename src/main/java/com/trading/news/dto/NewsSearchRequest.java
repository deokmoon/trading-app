package com.trading.news.dto;

import com.trading.news.constant.Sort;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import static com.trading.news.constant.NaverKakaoConstant.DEFAULT_PAGE;
import static com.trading.news.constant.NaverKakaoConstant.DEFAULT_SIZE;
import static com.trading.news.constant.NaverKakaoConstant.ERROR_MSG_NO_KEYWORD;
import static com.trading.news.constant.NaverKakaoConstant.ERROR_MSG_PAGE_OVER_MAX_VALUE;
import static com.trading.news.constant.NaverKakaoConstant.ERROR_MSG_PAGE_UNDER_MIN_VALUE;
import static com.trading.news.constant.NaverKakaoConstant.ERROR_MSG_SIZE_OVER_MAX_VALUE;
import static com.trading.news.constant.NaverKakaoConstant.ERROR_MSG_SIZE_UNDER_MIN_VALUE;
import static com.trading.news.constant.NaverKakaoConstant.MAX_REQUEST_PAGE;
import static com.trading.news.constant.NaverKakaoConstant.MAX_REQUEST_SIZE;
import static com.trading.news.constant.NaverKakaoConstant.MIN_REQUEST_PAGE;
import static com.trading.news.constant.NaverKakaoConstant.MIN_REQUEST_SIZE;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NewsSearchRequest {

    @NotBlank(message = ERROR_MSG_NO_KEYWORD)
    private String query;

    private Sort sort;

    @Min(value = MIN_REQUEST_PAGE, message = ERROR_MSG_PAGE_UNDER_MIN_VALUE)
    @Max(value = MAX_REQUEST_PAGE, message = ERROR_MSG_PAGE_OVER_MAX_VALUE)
    private Integer start;

    @Min(value = MIN_REQUEST_SIZE, message = ERROR_MSG_SIZE_UNDER_MIN_VALUE)
    @Max(value = MAX_REQUEST_SIZE, message = ERROR_MSG_SIZE_OVER_MAX_VALUE)
    private Integer display;

    public NewsSearchRequest(String query, Sort sort, Integer start, Integer display) {
        this.query = query;
        this.sort = sort == null ? Sort.ACCURACY : sort;
        this.start = start == null ? DEFAULT_PAGE : start;
        this.display = display == null ? DEFAULT_SIZE : display;
    }
}
