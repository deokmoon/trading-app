package com.trading.domain.board.repository;

import com.trading.domain.board.Board;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface BoardRepository extends Repository<Board, String> {

    Board save(Board board);

    Optional<Board> findByBoardId(String boardId);

    void deleteByBoardId(String boardId);

}
