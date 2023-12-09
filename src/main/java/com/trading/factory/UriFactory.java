package com.trading.factory;

import com.trading.news.dto.NewsSearchRequest;
import org.springframework.web.util.UriBuilder;

import java.net.URI;

public interface UriFactory {
    URI uri(NewsSearchRequest request, UriBuilder builder);
}
