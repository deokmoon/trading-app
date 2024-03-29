package com.trading.controller.board.request;

import com.trading.domain.board.constants.BoardType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class BoardReq {

    private MultipartFile image;
    private String title;
    private String content;
    private BoardType boardType;
    private String marketCode;
    private String writer;
}
