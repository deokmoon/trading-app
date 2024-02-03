package com.trading.apiclient.navernewssearch.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.trading.apiclient.navernewssearch.mapper.NaverLocalDateTimeDeserializer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NaverNewsItem {
    private String title;
    private String originallink;
    private String link;
    private String description;

    @JsonDeserialize(using = NaverLocalDateTimeDeserializer.class)
    private LocalDateTime pubDate;
}
