package com.trading.controller.request;

import lombok.Getter;

@Getter
public class EmailAuthReq {

    private String email;

    private String code;

}
