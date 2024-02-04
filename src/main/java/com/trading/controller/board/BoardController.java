package com.trading.controller.board;

import com.trading.controller.board.request.BoardListReq;
import com.trading.controller.board.request.CreateBoardReq;
import com.trading.controller.board.request.UpdateBoardReq;
import com.trading.controller.board.response.BoardListRes;
import com.trading.controller.board.response.BoardRes;
import com.trading.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public String createBoard(CreateBoardReq req) {
        return boardService.createBoard(req);
    }

    @GetMapping
    public BoardListRes getBoardList(BoardListReq req) {
        return boardService.getBoardList(req);
    }

    @GetMapping("/{boardId}")
    public BoardRes getBoard(@PathVariable String boardId) {
        return boardService.getBoard(boardId);
    }

    @PutMapping
    public String updateBoard(UpdateBoardReq req) {
        return boardService.updateBoard(req);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard(@PathVariable String boardId) {
        boardService.deleteBoard(boardId);
    }

    @PostMapping("/like/{boardId}")
    public void likeBoard(@PathVariable String boardId) {
        boardService.likeBoard(boardId);
    }

}
