package com.trading.controller.ui.request;

import lombok.Getter;

@Getter
public class FindPasswordAuthReq {

    private String email;

    private String code;

}
