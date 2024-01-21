package com.trading.domain.board.service.impl;

import com.trading.domain.board.FeedBoard;
import com.trading.domain.board.repository.FeedBoardRepository;
import com.trading.controller.ui.request.FeedBoardRequest;
import com.trading.controller.ui.response.FeedBoardResponse;
import com.trading.controller.ui.request.FeedBoardSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedBoardService {

    private final FeedBoardRepository feedBoardRepository;

    @Transactional
    public FeedBoardResponse createFeedBoard(FeedBoardRequest request) throws IOException {
        return FeedBoardResponse.from(feedBoardRepository.save(FeedBoard.from(request)));
    }

    public List<FeedBoardResponse> showFeedBoardList(FeedBoardSearchRequest request) {
        Pageable pageable = PageRequest.of(request.getStart(), request.getDisplay(), getSort(request.getSort().toSortDirection()));
        Page<FeedBoard> boards = feedBoardRepository.findByTitleContainingOrContentContaining(request.getQuery(), request.getQuery(),  pageable);
        return FeedBoardResponse.fromList(boards);
    }

    private Sort getSort(Sort.Direction sort) {
        return Sort.by(Sort.Order.by("createdDatetime").with(sort));
    }
}
