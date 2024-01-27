package com.trading.controller.response;

import com.trading.controller.constants.EmailStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EmailStatusRes {

    private String email;

    private EmailStatus emailStatus;

    private String message;

    public static EmailStatusRes of(String email, EmailStatus emailStatus) {
        return EmailStatusRes.builder()
                .email(email)
                .emailStatus(emailStatus)
                .message(emailStatus.getMessage())
                .build();
    }

}
