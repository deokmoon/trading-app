package com.trading.client.ui;

import com.trading.client.application.NewsSearchService;
import com.trading.news.dto.NewsSearchRequest;
import com.trading.news.dto.NewsSearchResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NewsSearchController {

    private final NewsSearchService newsSearchService;

    @GetMapping("/news")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NewsSearchResponse> getResults(@Valid NewsSearchRequest request) {
        return ResponseEntity.ok(newsSearchService.search(request));
    }
}
