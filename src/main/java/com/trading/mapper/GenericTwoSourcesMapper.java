package com.trading.mapper;

public interface GenericTwoSourcesMapper<S1, S2, T> {

    T from(S1 source1, S2 source2);
}
