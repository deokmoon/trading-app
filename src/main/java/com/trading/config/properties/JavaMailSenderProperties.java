package com.trading.config.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "spring.mail")
@RequiredArgsConstructor
public class JavaMailSenderProperties {

    private final String host;

    private final Integer port;

    private final String username;

    private final String password;

    private final String defaultEncoding;

//    private final Properties properties;

//    @Getter
//    @RequiredArgsConstructor
//    public static class Properties {
//
//        private final Mail mail;
//
//        @Getter
//        @RequiredArgsConstructor
//        public static class Mail {
//
//            private final Smtp smtp;
//
//            @Getter
//            @RequiredArgsConstructor
//            public static class Smtp {
//
//                private final boolean auth;
//
//                private final Integer timeout;
//
//                private final Starttls starttls;
//
//                @Getter
//                @RequiredArgsConstructor
//                public class Starttls {
//
//                    private final boolean enable;
//
//                }
//
//            }
//
//        }
//
//    }

}
