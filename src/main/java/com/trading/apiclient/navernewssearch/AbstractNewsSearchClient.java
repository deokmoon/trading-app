package com.trading.apiclient.navernewssearch;

import com.trading.apiclient.navernewssearch.request.NewsSearchRequest;
import com.trading.apiclient.navernewssearch.response.NewsSearchResponse;

public abstract class AbstractNewsSearchClient implements NewsSearchClient {

    private NewsSearchClient nextClient;

    @Override
    public NewsSearchResponse search(NewsSearchRequest request) {
        try {
            return handleSearch(request);
        } catch (Exception e) {
            NewsSearchClient next = getNextClient();
            if (next != null) {
                return next.search(request);
            } else {
                throw e;
            }
        }
    }

    @Override
    public void setNextChainClient(NewsSearchClient nextClient) {
        this.nextClient = nextClient;
    }

    abstract NewsSearchResponse handleSearch(NewsSearchRequest request);

    public NewsSearchClient getNextClient() {
        return nextClient;
    }

}
