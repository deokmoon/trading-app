package com.trading.board.client;

import com.trading.board.application.FeedCommentService;
import com.trading.board.dto.FeedBoardCommentRequest;
import com.trading.board.dto.FeedBoardCommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feed/comment")
@RequiredArgsConstructor
public class FeedCommentController {

    private final FeedCommentService feedCommentService;

    @PostMapping("/create")
    public ResponseEntity<FeedBoardCommentResponse> createFeed(FeedBoardCommentRequest feedBoardCommentRequest) {
        FeedBoardCommentResponse response = feedCommentService.createComment(feedBoardCommentRequest);
        return ResponseEntity.ok(response);
    }
}
