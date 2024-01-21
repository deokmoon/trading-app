package com.trading.apiclient.navernewssearch.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NewsSearchResponse {
    private List<NewsDocumentResponse> news;
    private Integer currentPage;
    private Integer size;
    private Long total;
}
