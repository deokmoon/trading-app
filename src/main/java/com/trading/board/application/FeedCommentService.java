package com.trading.board.application;

import com.trading.board.domain.FeedBoard;
import com.trading.board.domain.FeedComment;
import com.trading.board.domain.repository.FeedBoardRepository;
import com.trading.board.domain.repository.FeedCommentRepository;
import com.trading.board.dto.FeedBoardCommentRequest;
import com.trading.board.dto.FeedBoardCommentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static com.trading.board.constants.ErrorMessage.INVALID_IMAGE_REQUEST;
import static com.trading.board.constants.ErrorMessage.NO_SUCH_BOARD;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedCommentService {

    private final FeedCommentRepository feedCommentRepository;
    private final FeedBoardRepository feedBoardRepository;

    public FeedBoardCommentResponse createComment(FeedBoardCommentRequest request) {
        FeedBoard board = findBoard(Long.parseLong(request.getBoardId()));
        FeedComment feedComment;
        try {
             feedComment = FeedComment.from(request, board);
        } catch (IOException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            log.error(errors.toString());
            throw new IllegalArgumentException(INVALID_IMAGE_REQUEST);
        }
        feedCommentRepository.save(feedComment);
        return FeedBoardCommentResponse.from(feedComment);
    }

    private FeedBoard findBoard(long boardId) {
        return feedBoardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException(NO_SUCH_BOARD));
    }
}
