package com.trading.domain.email.service;

import com.trading.domain.email.dto.EmailDto;

public interface EmailService {

    void sendEmail(EmailDto emailDto);

}
