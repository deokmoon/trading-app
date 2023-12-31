package com.trading.board.dto;

import com.trading.board.constants.BoardType;
import com.trading.board.domain.FeedBoard;
import com.trading.board.domain.Tag;
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
public class FeedBoardResponse {

    private String id;
    private String image;
    private String writer;
    private String createdDate;
    private String title;
    private String contents;
    private List<Tag> tags;
    private int viewCount;
    private List<FeedBoardCommentResponse> comments;
    private int likeCount;
    private int bookmarksCount;
    private boolean isLike;
    private boolean isFollow;
    private String marketCode;
    private BoardType boardType;

    public static FeedBoardResponse from(FeedBoard feedBoard) {
        return FeedBoardResponse.builder()
                .id(feedBoard.getId().toString())
                .image(Base64.getEncoder().encodeToString(feedBoard.getImage()))
                .writer(feedBoard.getWriter())
                .createdDate(feedBoard.getCreatedDate().toString())
                .title(feedBoard.getTitle())
                .contents(feedBoard.getContent())
                .tags(feedBoard.getTags())
                .viewCount(feedBoard.getViewCount())
                .comments(Optional.ofNullable(feedBoard.getComments())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(FeedBoardCommentResponse::from)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList()))
                .likeCount(feedBoard.getLikeCount())
                .bookmarksCount(feedBoard.getBookmarksCount())
                .isLike(feedBoard.isLike())
                .isFollow(feedBoard.isFollow())
                .marketCode(feedBoard.getMarketCode())
                .boardType(feedBoard.getBoardType())
                .build();
    }

    public static List<FeedBoardResponse> fromList(List<FeedBoard> feedBoards) {
        return feedBoards.stream()
                .map(FeedBoardResponse::from)
                .collect(Collectors.toList());
    }

}
