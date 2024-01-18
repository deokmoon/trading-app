package com.trading.domain.redis.service;

import java.time.Duration;
import java.util.Optional;

public interface RedisService {

    void setValue(String key, String value, Duration expiration);

    Optional<String> getValue(String key);

    Boolean delValue(String refreshTokenKey);

}
