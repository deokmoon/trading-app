package com.trading.news.dto.mapper;

import com.trading.mapper.GenericTwoSourcesMapper;
import com.trading.news.dto.NewsDocumentResponse;
import com.trading.news.dto.NewsSearchRequest;
import com.trading.news.dto.NewsSearchResponse;
import com.trading.news.dto.naver.NaverNewsItem;
import com.trading.news.dto.naver.NaverNewsSearchResult;
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
