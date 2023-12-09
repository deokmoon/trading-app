package com.trading.news.dto.naver;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.trading.news.dto.mapper.NaverLocalDateTimeDeserializer;
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
