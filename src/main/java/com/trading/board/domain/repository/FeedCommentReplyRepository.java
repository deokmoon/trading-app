package com.trading.board.domain.repository;

import com.trading.board.domain.FeedCommentReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedCommentReplyRepository extends JpaRepository<FeedCommentReply, Long> {
}
