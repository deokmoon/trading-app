package com.trading.news.client;

import com.trading.factory.NaverUriFactory;
import com.trading.factory.UriFactory;
import com.trading.news.dto.mapper.ResponseNaverMapper;
import com.trading.news.dto.NewsSearchRequest;
import com.trading.news.dto.NewsSearchResponse;
import com.trading.news.dto.naver.NaverNewsSearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;

@Service
public class NaverNewsSearchClient extends AbstractNewsSearchClient {
    private static final String NAVER_CLIENT_ID = "X-Naver-Client-Id";
    private static final String NAVER_CLIENT_SECRET = "X-Naver-Client-Secret";
    private final WebClient webClient;
    private final ResponseNaverMapper mapper;
    private final UriFactory uriFactory = new NaverUriFactory();

    @Value("${application.external-api.naver.scheme}")
    private String scheme;

    @Value("${application.external-api.naver.host}")
    private String host;

    @Value("${application.external-api.naver.path}")
    private String path;

    @Value("${application.external-api.naver.client-id}")
    private String clientId;

    @Value("${application.external-api.naver.client-secret}")
    private String clientSecret;

    public NaverNewsSearchClient(WebClient webClient, ResponseNaverMapper mapper) {
        this.webClient = webClient;
        this.mapper = mapper;
    }

    @Override
    public NewsSearchResponse handleSearch(NewsSearchRequest request) {
        NaverNewsSearchResult searchResult = webClient.get()
                .uri(builder -> getUri(request, builder))
                .header(NAVER_CLIENT_ID, clientId)
                .header(NAVER_CLIENT_SECRET, clientSecret)
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError()
                        , clientResponse ->
                                clientResponse.bodyToMono(String.class)
                                        .map(IllegalArgumentException::new))
                .bodyToMono(NaverNewsSearchResult.class)
                .block();

        return mapper.from(searchResult, request);
    }

    private URI getUri(NewsSearchRequest request, UriBuilder builder) {
        builder.host(host)
                .path(path)
                .scheme(scheme);
        return uriFactory.uri(request, builder);
    }
}
