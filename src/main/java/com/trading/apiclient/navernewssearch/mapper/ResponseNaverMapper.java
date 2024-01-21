package com.trading.apiclient.navernewssearch.mapper;

import com.trading.apiclient.navernewssearch.response.NewsDocumentResponse;
import com.trading.apiclient.navernewssearch.request.NewsSearchRequest;
import com.trading.apiclient.navernewssearch.response.NewsSearchResponse;
import com.trading.apiclient.navernewssearch.response.NaverNewsItem;
import com.trading.apiclient.navernewssearch.response.NaverNewsSearchResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResponseNaverMapper extends GenericTwoSourcesMapper<NaverNewsSearchResult, NewsSearchRequest, NewsSearchResponse> {
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "contents")
    @Mapping(source = "link", target = "originLink")
    @Mapping(source = "originallink", target = "platformLink")
    @Mapping(source = "pubDate", target = "createTime")
    NewsDocumentResponse from(NaverNewsItem item);

    @Override
    @Mapping(source = "searchResult.items", target = "news")
    @Mapping(source = "searchResult.total", target = "total")
    @Mapping(source = "searchRequest.start", target = "currentPage")
    @Mapping(source = "searchRequest.display", target = "size")
    NewsSearchResponse from(NaverNewsSearchResult searchResult, NewsSearchRequest searchRequest);
}
