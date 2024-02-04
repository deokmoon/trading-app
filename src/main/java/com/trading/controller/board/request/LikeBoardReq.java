package com.trading.controller.board.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LikeBoardReq {

    @NotNull
    private String boardId;

}
