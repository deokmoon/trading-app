package com.trading.controller.ui.response;

import com.trading.domain.comment.FeedCommentReply;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Base64;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class FeedBoardCommentReplyResponse {

    private String id;

    private String image;

    private String writer;

    private String createdDate;

    private String reply;

    private int likeCount;

    public static FeedBoardCommentReplyResponse from(FeedCommentReply commentReply) {
        return FeedBoardCommentReplyResponse.builder()
                .id(commentReply.getId().toString())
                .image(Base64.getEncoder().encodeToString(commentReply.getImage()))
                .writer(commentReply.getWriter())
                .createdDate(commentReply.getCreatedDatetime().toString())
                .reply(commentReply.getReply())
                .likeCount(commentReply.getLikeCount())
                .build();
    }

}
