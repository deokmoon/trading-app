package com.trading.client.application.news.service;

import com.trading.news.client.NewsSearchClient;
import com.trading.news.dto.NewsSearchRequest;
import com.trading.news.dto.NewsSearchResponse;
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
