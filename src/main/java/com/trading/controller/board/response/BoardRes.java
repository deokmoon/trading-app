package com.trading.controller.board.response;

import com.trading.common.annotation.Description;
import com.trading.domain.board.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardRes {

    private String boardId;

    private String subject;

    private String boardDesc;

    @Description("생성자ID")
    private String cretId;

    private LocalDateTime cretDatetime;

    @Description("수정자ID")
    private String modId;

    private LocalDateTime modDatetime;

    public static BoardRes from(Board board) {
        return BoardRes.builder()
                .boardId(board.getBoardId())
                .subject(board.getSubject())
                .boardDesc(board.getBoardDesc())
                .cretId(board.getCretId())
                .cretDatetime(board.getCretDatetime())
                .modId(board.getModId())
                .modDatetime(board.getModDatetime())
                .build();
    }

}
