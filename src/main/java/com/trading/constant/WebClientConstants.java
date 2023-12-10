package com.trading.constant;

public class WebClientConstants {
    // WEB CLIENT - HTTP CLIENT
    public static final int CONNECT_TIMEOUT_MILLIS_VALUE = 10_000;
    public static final int RESPONSE_TIMEOUT_MILLS_VALUE = 5_000;
    public static final int READ_TIMEOUT_MILLS_VALUE = 5_000;
    public static final int WRITE_TIMEOUT_MILLS_VALUE = 5_000;

    // WEB CLIENT - CONNECTION PROVIDER
    public static final String CONNECTION_NAME = "http-pool";
    public static final int CONNECTION_MAX_TIMEOUT = 10;
    public static final int CONNECTION_PENDING_ACQUIRE_TIMEOUT = 0;
    public static final int CONNECTION_PENDING_ACQUIRE_COUNT = -1; // NO LIMIT
    public static final long CONNECTION_MAX_IDLE_TIME = 2_000L;
    public static final int  MAX_INMEMORY_SIZE = 1024 * 1024; // default: 256 * 1024 -> 현 프로젝트 max buffer 1MB 적용
}
