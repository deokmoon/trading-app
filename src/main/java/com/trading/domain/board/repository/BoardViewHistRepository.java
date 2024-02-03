package com.trading.domain.board.repository;

import com.trading.domain.board.BoardViewHist;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BoardViewHistRepository extends Repository<BoardViewHist, String> {

    BoardViewHist save(BoardViewHist boardViewHist);

    List<BoardViewHist> findByBoardViewHistId(String boardViewHistId);

}
