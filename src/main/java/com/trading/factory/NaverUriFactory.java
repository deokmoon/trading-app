package com.trading.factory;

import com.trading.news.dto.NewsSearchRequest;
import org.springframework.web.util.UriBuilder;

import java.net.URI;

public class NaverUriFactory implements UriFactory {
    private static final String QUERY = "query";
    private static final String SORT = "sort";
    private static final String START = "start";
    private static final String DISPLAY = "display";

    @Override
    public URI uri(NewsSearchRequest request, UriBuilder builder) {
        builder.queryParam(QUERY, request.getQuery());
        builder.queryParam(SORT, request.getSort().getNaverSort());
        builder.queryParam(START, getStart(request));
        builder.queryParam(DISPLAY, request.getDisplay());
        return builder.build();
    }

    private static int getStart(NewsSearchRequest request) {
        return (request.getStart() - 1) * request.getDisplay() + 1;
    }
}
