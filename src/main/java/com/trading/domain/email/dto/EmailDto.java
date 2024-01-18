package com.trading.domain.email.dto;

import com.trading.common.annotation.Description;
import com.trading.domain.email.constants.EmailType;
import com.trading.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmailDto {

    @Description("수신인 이메일")
    private String emailTo;

    @Description("제목")
    private String subject;

    @Description("내용")
    private String text;

//    @Description("URL QUERY")
//    private String urlQuery;

    @Description("Code")
    private String code;

    public static EmailDto of(String emailTo, String subject, String text) {
        return EmailDto.builder()
                .emailTo(emailTo)
                .subject(subject)
                .text(text)
                .build();
    }

    public static EmailDto of(EmailType emailType, User user) {

//        String urlQuery = new StringBuilder("?screen=")
//                .append(emailType.getCode())
//                .append("&userID=").append(user.getUserId().toLowerCase())
//                .append("&authKey=").append(user.getAuthKey().toLowerCase())
//                .toString();

        return EmailDto.builder()
                .emailTo(user.getEmail())
                .subject(emailType.getSubject())
                .text(emailType.getText())
//                .urlQuery(urlQuery)
                .code(user.getAuthKey())
                .build();
    }

}
