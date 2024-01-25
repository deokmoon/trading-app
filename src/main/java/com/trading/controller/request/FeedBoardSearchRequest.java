package com.trading.controller.request;

import com.trading.domain.board.constants.BoardSort;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.trading.domain.board.constants.BoardConstants.DEFAULT_PAGE;
import static com.trading.domain.board.constants.BoardConstants.DEFAULT_SIZE;
import static com.trading.domain.board.constants.BoardConstants.ERROR_MSG_PAGE_OVER_MAX_VALUE;
import static com.trading.domain.board.constants.BoardConstants.ERROR_MSG_PAGE_UNDER_MIN_VALUE;
import static com.trading.domain.board.constants.BoardConstants.ERROR_MSG_SIZE_OVER_MAX_VALUE;
import static com.trading.domain.board.constants.BoardConstants.ERROR_MSG_SIZE_UNDER_MIN_VALUE;
import static com.trading.domain.board.constants.BoardConstants.MAX_REQUEST_PAGE;
import static com.trading.domain.board.constants.BoardConstants.MAX_REQUEST_SIZE;
import static com.trading.domain.board.constants.BoardConstants.MIN_REQUEST_PAGE;
import static com.trading.domain.board.constants.BoardConstants.MIN_REQUEST_SIZE;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeedBoardSearchRequest {
    private String query;
    private String tags;
    private BoardSort sort;

    @Min(value = MIN_REQUEST_PAGE, message = ERROR_MSG_PAGE_UNDER_MIN_VALUE)
    @Max(value = MAX_REQUEST_PAGE, message = ERROR_MSG_PAGE_OVER_MAX_VALUE)
    private Integer start;

    @Min(value = MIN_REQUEST_SIZE, message = ERROR_MSG_SIZE_UNDER_MIN_VALUE)
    @Max(value = MAX_REQUEST_SIZE, message = ERROR_MSG_SIZE_OVER_MAX_VALUE)
    private Integer display;

    public FeedBoardSearchRequest(String query, String tags, BoardSort sort, Integer start, Integer display) {
        this.query = query == null ? "" : query;
        this.tags = tags == null ? "" : tags;
        this.sort = sort == null ? BoardSort.ASCENDING : sort;
        this.start = start == null ? DEFAULT_PAGE : start;
        this.display = display == null ? DEFAULT_SIZE : display;
    }
}
