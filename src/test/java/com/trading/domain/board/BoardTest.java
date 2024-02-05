package com.trading.domain.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    @Test
    @DisplayName("게시판을 생성하면 likeCount 는 0 이다.")
    final void 게시판_생성_테스트() {
        final Long expect = 0L;

        Board board = new Board();

        assertThat(board.getLikeCount()).isEqualTo(expect);
    }

    @Test
    @DisplayName("increaseLikeCount 메서드가 호출되면 likeCount 가 1 이 증가된다.")
    final void likeCount_증가_테스트() {
        final Long expect = 1L;
        Board board = new Board();

        board.increaseLikeCount();

        assertThat(board.getLikeCount()).isEqualTo(expect);
    }

}