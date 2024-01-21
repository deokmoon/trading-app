package com.trading.domain.board.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Sort;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum BoardSort {

    ASCENDING("acs"),
    DESCENDING("dcs");

    private final String sortType;

    public Sort.Direction toSortDirection() {
        return this == ASCENDING ? Sort.Direction.ASC : Sort.Direction.DESC;
    }

}
