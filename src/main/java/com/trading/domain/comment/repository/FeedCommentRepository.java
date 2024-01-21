package com.trading.domain.comment.repository;

import com.trading.domain.comment.FeedComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedCommentRepository extends JpaRepository<FeedComment, Long> {
}
