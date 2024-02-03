package com.trading.domain.comment.repository;

import com.trading.domain.comment.FeedCommentReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedCommentReplyRepository extends JpaRepository<FeedCommentReply, Long> {
}
