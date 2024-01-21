package com.trading.apiclient.navernewssearch.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NewsDocumentResponse {

    private String title;
    private String contents;
    private String platformLink;
    private String originLink;
    private LocalDateTime createTime;
}
