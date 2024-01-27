package com.trading.controller.board.request;

import com.trading.domain.board.Board;
import com.trading.domain.user.User;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateBoardReq {

    private String subject;

    private String desc;

    public Board toBoard(User user) {
        String boardId = UUID.randomUUID().toString();
        return Board.builder()
                .boardId(boardId)
                .subject(subject)
                .boardDesc(desc)
                .cretId(user.getUserId())
                .modId(user.getUserId())
                .build();
    }

}
