package com.trading.board.domain.repository;

import com.trading.board.domain.FeedBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBoardRepository extends JpaRepository<FeedBoard, Long> {
    Page<FeedBoard> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}
