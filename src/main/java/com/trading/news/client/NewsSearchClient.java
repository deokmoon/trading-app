package com.trading.news.client;

import com.trading.news.dto.NewsSearchRequest;
import com.trading.news.dto.NewsSearchResponse;

public interface NewsSearchClient {
    NewsSearchResponse search(NewsSearchRequest request);

    void setNextChainClient(NewsSearchClient client);
}
