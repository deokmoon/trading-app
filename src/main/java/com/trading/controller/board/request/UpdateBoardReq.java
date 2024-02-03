package com.trading.controller.board.request;

import lombok.Getter;

@Getter
public class UpdateBoardReq {

    private String boardId;

    private String subject;

    private String boardDesc;

}
