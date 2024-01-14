package com.trading.config;

import com.trading.config.properties.JavaMailSenderProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@RequiredArgsConstructor
@Configuration
public class JavaMailSenderConfig {

    private final JavaMailSenderProperties javaMailSenderProperties;

    @Bean
    public JavaMailSender javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(javaMailSenderProperties.getHost());
        javaMailSender.setUsername(javaMailSenderProperties.getUsername());
        javaMailSender.setPassword(javaMailSenderProperties.getPassword());
        javaMailSender.setPort(javaMailSenderProperties.getPort());

        javaMailSender.setJavaMailProperties(getMailProperties());

        return javaMailSender;
    }

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.debug", "true");
        return properties;
    }
}
