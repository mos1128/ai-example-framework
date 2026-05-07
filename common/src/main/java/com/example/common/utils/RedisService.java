package com.example.common.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis基础工具类
 *
 * @author mos
 */
@Component
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void setObject(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setObject(String key, Object value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public Object getObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Boolean deleteKey(String key) {
        return redisTemplate.delete(key);
    }

    public Boolean expire(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }
}
