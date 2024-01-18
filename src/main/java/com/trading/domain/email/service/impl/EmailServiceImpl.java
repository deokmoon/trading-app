package com.trading.domain.email.service.impl;

import com.trading.common.utils.MvcUtils;
import com.trading.domain.email.dto.EmailDto;
import com.trading.domain.email.service.EmailService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String emailFrom;

    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(EmailDto emailDto) {
        HttpServletRequest httpServletRequest = MvcUtils.getHttpServletRequest();
        String proxyHost = httpServletRequest.getHeader("x-forwarded-host");
        String host = StringUtils.hasText(proxyHost) ? proxyHost : httpServletRequest.getHeader("host");

        String text = new StringBuilder(emailDto.getText())
//                .append(host)
                .append(emailDto.getCode())
                .toString();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(emailDto.getEmailTo());
        message.setSubject(emailDto.getSubject());
        message.setText(text);

        mailSender.send(message);
    }

}
