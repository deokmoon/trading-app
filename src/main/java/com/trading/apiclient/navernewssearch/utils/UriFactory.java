package com.trading.apiclient.navernewssearch.utils;

import com.trading.apiclient.navernewssearch.request.NewsSearchRequest;
import org.springframework.web.util.UriBuilder;

import java.net.URI;

public interface UriFactory {
    URI uri(NewsSearchRequest request, UriBuilder builder);
}
