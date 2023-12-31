package com.trading.board.domain.repository;

import com.trading.board.domain.FeedBoard;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedBoardRepository extends JpaRepository<FeedBoard, Long> {
    List<FeedBoard> findByTitleOrContentContaining(String query, Pageable pageable);
}
