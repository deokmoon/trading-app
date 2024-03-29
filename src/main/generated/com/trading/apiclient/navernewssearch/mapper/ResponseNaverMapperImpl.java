package com.trading.apiclient.navernewssearch.mapper;

import com.trading.apiclient.navernewssearch.request.NewsSearchRequest;
import com.trading.apiclient.navernewssearch.response.NaverNewsItem;
import com.trading.apiclient.navernewssearch.response.NaverNewsSearchResult;
import com.trading.apiclient.navernewssearch.response.NewsDocumentResponse;
import com.trading.apiclient.navernewssearch.response.NewsSearchResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-03T12:15:57+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8.1 (Homebrew)"
)
@Component
public class ResponseNaverMapperImpl implements ResponseNaverMapper {

    @Override
    public NewsDocumentResponse from(NaverNewsItem item) {
        if ( item == null ) {
            return null;
        }

        String title = null;
        String contents = null;
        String originLink = null;
        String platformLink = null;
        LocalDateTime createTime = null;

        title = item.getTitle();
        contents = item.getDescription();
        originLink = item.getLink();
        platformLink = item.getOriginallink();
        createTime = item.getPubDate();

        NewsDocumentResponse newsDocumentResponse = new NewsDocumentResponse( title, contents, platformLink, originLink, createTime );

        return newsDocumentResponse;
    }

    @Override
    public NewsSearchResponse from(NaverNewsSearchResult searchResult, NewsSearchRequest searchRequest) {
        if ( searchResult == null && searchRequest == null ) {
            return null;
        }

        List<NewsDocumentResponse> news = null;
        Long total = null;
        if ( searchResult != null ) {
            news = naverNewsItemListToNewsDocumentResponseList( searchResult.getItems() );
            if ( searchResult.getTotal() != null ) {
                total = searchResult.getTotal().longValue();
            }
        }
        Integer currentPage = null;
        Integer size = null;
        if ( searchRequest != null ) {
            currentPage = searchRequest.getStart();
            size = searchRequest.getDisplay();
        }

        NewsSearchResponse newsSearchResponse = new NewsSearchResponse( news, currentPage, size, total );

        return newsSearchResponse;
    }

    protected List<NewsDocumentResponse> naverNewsItemListToNewsDocumentResponseList(List<NaverNewsItem> list) {
        if ( list == null ) {
            return null;
        }

        List<NewsDocumentResponse> list1 = new ArrayList<NewsDocumentResponse>( list.size() );
        for ( NaverNewsItem naverNewsItem : list ) {
            list1.add( from( naverNewsItem ) );
        }

        return list1;
    }
}
