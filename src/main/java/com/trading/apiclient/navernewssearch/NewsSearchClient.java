package com.trading.apiclient.navernewssearch;

import com.trading.apiclient.navernewssearch.request.NewsSearchRequest;
import com.trading.apiclient.navernewssearch.response.NewsSearchResponse;

public interface NewsSearchClient {

    NewsSearchResponse search(NewsSearchRequest request);

    void setNextChainClient(NewsSearchClient client);

}
