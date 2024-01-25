package com.trading.controller.request;

import lombok.Getter;

@Getter
public class FindPasswordAuthReq {

    private String email;

    private String code;

}
