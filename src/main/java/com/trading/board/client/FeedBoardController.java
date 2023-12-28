package com.trading.board.client;

import com.trading.board.application.FeedBoardService;
import com.trading.board.dto.FeedBoardRequest;
import com.trading.board.dto.FeedBoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedBoardController {


    private final FeedBoardService feedBoardService;

    @PostMapping("/create")
    public ResponseEntity<FeedBoardResponse> createFeedBoard(@ModelAttribute FeedBoardRequest request) throws IOException {
        return ResponseEntity.ok(feedBoardService.createFeedBoard(request));
    }
}
