package com.trading.domain.board.service;

import com.trading.controller.board.request.BoardListReq;
import com.trading.controller.board.request.CreateBoardReq;
import com.trading.controller.board.request.UpdateBoardReq;
import com.trading.controller.board.response.BoardListRes;
import com.trading.controller.board.response.BoardRes;

public interface BoardService {

    String createBoard(CreateBoardReq req);

    BoardListRes getBoardList(BoardListReq req);

    BoardRes getBoard(String boardId);

    String updateBoard(UpdateBoardReq req);

    void deleteBoard(String boardId);

}
