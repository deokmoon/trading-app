package com.trading.controller.response;

import com.trading.controller.constants.EmailStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EmailStatusRes {

    private String email;

    private EmailStatus emailStatus;

}
