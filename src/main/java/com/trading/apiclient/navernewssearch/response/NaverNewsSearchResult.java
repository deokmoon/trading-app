package com.trading.apiclient.navernewssearch.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NaverNewsSearchResult {

    private Integer total;
    private Integer start;
    private Integer display;
    private List<NaverNewsItem> items;
}
