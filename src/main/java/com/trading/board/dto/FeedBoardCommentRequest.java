package com.trading.board.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class FeedBoardCommentRequest {

    private MultipartFile image;;
    private String writer;
    private String comment;
    private String boardId;

}
