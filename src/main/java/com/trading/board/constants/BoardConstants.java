package com.trading.board.constants;

public class BoardConstants {

    public static final int MIN_REQUEST_PAGE = 0;
    public static final int MIN_REQUEST_SIZE = 1;
    public static final int MAX_REQUEST_PAGE = 49;
    public static final int MAX_REQUEST_SIZE = 50;

    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_SIZE = 10;

    public static final String ERROR_MSG_PAGE_UNDER_MIN_VALUE = "조회하고자 하는 페이지는 1 이상의 숫자를 입력해주세요.";
    public static final String ERROR_MSG_SIZE_UNDER_MIN_VALUE = "페이지당 검색 결과의 수는 1 이상의 숫자를 입력해주세요.";
    public static final String ERROR_MSG_PAGE_OVER_MAX_VALUE = "페이지는 50 이하의 숫자를 입력해주세요.";
    public static final String ERROR_MSG_SIZE_OVER_MAX_VALUE = "페이지당 검색 결과는 50 이하의 숫자를 입력해주세요.";
}
