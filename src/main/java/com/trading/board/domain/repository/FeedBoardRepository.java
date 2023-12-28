package com.trading.board.domain.repository;

import com.trading.board.domain.FeedBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBoardRepository extends JpaRepository<FeedBoard, Long> {
}
