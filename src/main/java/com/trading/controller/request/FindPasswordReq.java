package com.trading.controller.request;

import com.trading.common.annotation.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindPasswordReq {

    @Description("이메일주소")
    private String email;

}
