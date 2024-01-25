package com.trading.controller.response;

import com.trading.domain.board.Board;
import com.trading.domain.board.constants.BoardType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;
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

//    private List<Tag> tags;

    private int viewCount;

    private List<FeedBoardCommentResponse> comments;

    private int likeCount;

    private int bookmarksCount;

    private boolean isLike;

    private boolean isFollow;

    private String marketCode;

    private BoardType boardType;

    public static FeedBoardResponse from(Board board) {
        return FeedBoardResponse.builder()
//                .id(board.getId().toString())
//                .image(Base64.getEncoder().encodeToString(board.getImage()))
//                .writer(board.getWriter())
//                .createdDate(board.getCreatedDatetime().toString())
//                .title(board.getTitle())
//                .contents(board.getContent())
//                .tags(board.getTags())
//                .viewCount(board.getViewCount())
//                .comments(Optional.ofNullable(board.getComments())
//                        .orElse(Collections.emptyList())
//                        .stream()
//                        .map(FeedBoardCommentResponse::from)
//                        .filter(Objects::nonNull)
//                        .collect(Collectors.toList()))
//                .likeCount(board.getLikeCount())
//                .bookmarksCount(board.getBookmarksCount())
//                .isLike(board.isLike())
//                .isFollow(board.isFollow())
//                .marketCode(board.getMarketCode())
//                .boardType(board.getBoardType())
                .build();
    }

    public static List<FeedBoardResponse> fromList(Page<Board> feedBoards) {
        return feedBoards.stream()
                .map(FeedBoardResponse::from)
                .collect(Collectors.toList());
    }

}
