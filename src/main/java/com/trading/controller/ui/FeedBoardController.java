package com.trading.controller.ui;

import com.trading.domain.board.service.impl.FeedBoardService;
import com.trading.controller.ui.request.FeedBoardRequest;
import com.trading.controller.ui.response.FeedBoardResponse;
import com.trading.controller.ui.request.FeedBoardSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedBoardController {


    private final FeedBoardService feedBoardService;

    @PostMapping("/create")
    public ResponseEntity<FeedBoardResponse> createFeedBoard(@ModelAttribute FeedBoardRequest request) throws IOException {
        return ResponseEntity.ok(feedBoardService.createFeedBoard(request));
    }

    @GetMapping("/list")
    public ResponseEntity<List<FeedBoardResponse>> showFeedBoardList(FeedBoardSearchRequest feedBoardSearchRequest) {
        return ResponseEntity.ok(feedBoardService.showFeedBoardList(feedBoardSearchRequest));
    }
}
