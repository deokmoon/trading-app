package com.trading.domain.news.service.impl;

import com.trading.apiclient.navernewssearch.NewsSearchClient;
import com.trading.apiclient.navernewssearch.request.NewsSearchRequest;
import com.trading.apiclient.navernewssearch.response.NewsSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsSearchService {

    private final List<NewsSearchClient> clients;
    public NewsSearchResponse search(NewsSearchRequest request) {
        return clients.get(0).search(request);
    }

    private void setNextClients() {
        for (int i = 0; i < clients.size() - 1; i++) {
            clients.get(i).setNextChainClient(clients.get(i + 1));
        }
    }
}
