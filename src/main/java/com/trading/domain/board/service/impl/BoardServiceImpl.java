package com.trading.domain.board.service.impl;

import com.trading.common.annotation.lock.CountLock;
import com.trading.common.errorcode.BoardErrorCode;
import com.trading.common.exception.TradRuntimeException;
import com.trading.common.utils.MvcUtils;
import com.trading.controller.board.request.BoardListReq;
import com.trading.controller.board.request.CreateBoardReq;
import com.trading.controller.board.request.UpdateBoardReq;
import com.trading.controller.board.response.BoardListRes;
import com.trading.controller.board.response.BoardRes;
import com.trading.domain.board.Board;
import com.trading.domain.board.repository.BoardRepository;
import com.trading.domain.board.service.BoardService;
import com.trading.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    @Override
    public String createBoard(CreateBoardReq req) {
        User user = MvcUtils.getLoginUser();
        Board board = boardRepository.save(req.toBoard(user));
        return board.getBoardId();
    }

    public BoardListRes getBoardList(BoardListReq req) {
        return null;
    }

    @Override
    public BoardRes getBoard(String boardId) {
        Optional<Board> maybeBoard = boardRepository.findByBoardId(boardId);
        return maybeBoard
                .map(BoardRes::from)
                .orElseThrow(() -> new TradRuntimeException(BoardErrorCode.NO_BOARD));
    }

    @Transactional
    @Override
    public String updateBoard(UpdateBoardReq req) {
        Optional<Board> maybeBoard = boardRepository.findByBoardId(req.getBoardId());
        return maybeBoard
                .map(board -> {
                    board.setSubject(req.getSubject());
                    board.setBoardDesc(req.getBoardDesc());
                    return board.getBoardId();
                })
                .orElseThrow(() -> new TradRuntimeException(BoardErrorCode.NO_BOARD));
    }

    @Transactional
    @Override
    public void deleteBoard(String boardId) {
        boardRepository.deleteByBoardId(boardId);
    }

    @Transactional
    @CountLock
    public void likeBoard(String boardId) {
        boardRepository.findByBoardId(boardId)
                .ifPresent(
                        Board::increaseLikeCount
                );
    }

}
