package com.trading.domain.email.service.impl;

import com.trading.domain.email.dto.EmailDto;
import com.trading.domain.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String emailFrom;

    private final JavaMailSender mailSender;

    @Value("${host}")
    private String host;

    @Override
    public void sendEmail(EmailDto emailDto) {

        String text = new StringBuilder(emailDto.getText())
                .append(host)
                .append(emailDto.getUrlQuery())
                .toString();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(emailDto.getEmailTo());
        message.setSubject(emailDto.getSubject());
        message.setText(text);

        mailSender.send(message);
    }

}
