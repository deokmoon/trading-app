package com.trading.domain.redis.service.impl;

import com.trading.domain.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public void setValue(String key, String value, Duration expSeconds) {
        redisTemplate.opsForValue().set(key, value, expSeconds);
    }

    @Override
    public Optional<String> getValue(String key) {
        String value = redisTemplate.opsForValue().get(key);
        if (Objects.isNull(value)) {
            return Optional.empty();
        }
        return Optional.of(value);
    }

    @Override
    public Boolean delValue(String refreshTokenKey) {
        return redisTemplate.delete(refreshTokenKey);
    }

}
