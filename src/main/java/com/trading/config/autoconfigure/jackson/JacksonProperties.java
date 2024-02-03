package com.trading.config.autoconfigure.jackson;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "config.autoconfigure.jackson")
public class JacksonProperties {
    private boolean enabled = true;
    private String dateTimeFormat = "yyyy.MM.dd HH:mm:ss";
    private String dateTimeFormatUTC = "yyyy-MM-dd'T'HH:mm:ss";

    private String dateFormat = "yyyy.MM.dd";
    private String timeFormat = "HH:mm:ss";

}

