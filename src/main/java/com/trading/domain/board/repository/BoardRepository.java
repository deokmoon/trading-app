package com.trading.domain.board.repository;

import com.trading.domain.board.Board;
import org.springframework.data.repository.Repository;

public interface BoardRepository extends Repository<Board, String> {

    Board save(Board board);

}
