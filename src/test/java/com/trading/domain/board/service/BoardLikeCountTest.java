package com.trading.domain.board.service;

import com.trading.domain.board.Board;
import com.trading.domain.board.repository.BoardRepository;
import com.trading.domain.board.service.impl.BoardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class BoardLikeCountTest {

    @InjectMocks
    private BoardServiceImpl boardService;

    @Mock
    private BoardRepository boardRepository;

    private Board board;
    private String boardId = "test";

    @BeforeEach
    final void setUp() {
        this.board = Board.builder()
                .boardId(boardId)
                .boardDesc("desc")
                .build();
    }

    @Test
    @DisplayName("게시글 좋아요에 대한 동시성 테스트")
    final void 게시글_좋아요_동시성테스트() throws InterruptedException {
        MockitoAnnotations.initMocks(this);
        int threadCount = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        given(boardRepository.findByBoardId(boardId)).willReturn(java.util.Optional.of(board));

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    boardService.likeBoard(boardId);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();

        assertThat(threadCount).isEqualTo(board.getLikeCount());
    }
}
