package com.trading.board.application;

import com.trading.board.domain.FeedBoard;
import com.trading.board.domain.repository.FeedBoardRepository;
import com.trading.board.dto.FeedBoardRequest;
import com.trading.board.dto.FeedBoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FeedBoardService {

    private final FeedBoardRepository feedBoardRepository;

    public FeedBoardResponse createFeedBoard(FeedBoardRequest request) throws IOException {
        return FeedBoardResponse.from(feedBoardRepository.save(FeedBoard.from(request)));
    }
}
