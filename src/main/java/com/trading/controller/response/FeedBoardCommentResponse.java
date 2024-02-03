package com.trading.controller.response;

import com.trading.domain.comment.FeedComment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class FeedBoardCommentResponse {

    private String id;
    private String image;
    private String writer;
    private String createdDate;
    private String comment;
    private int likeCount;
    private List<FeedBoardCommentReplyResponse> replys;

    public static FeedBoardCommentResponse from(FeedComment feedComment) {
        return FeedBoardCommentResponse.builder()
                .id(feedComment.getId().toString())
                .image(Base64.getEncoder().encodeToString(feedComment.getImage()))
                .writer(feedComment.getWriter())
                .createdDate(feedComment.getCretDatetime().toString()) // Assuming createdDate is a string
                .comment(feedComment.getComment())
                .likeCount(feedComment.getLikeCount())
                .replys(Optional.ofNullable(feedComment.getReplies())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(FeedBoardCommentReplyResponse::from)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList()))
                .build();
    }

}
