package com.MikoAi.filedatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
//using redis service to save success of fail as per the execution and returning the results
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void setValue(String key, String value) {
        // Set a key-value pair in Redis
        redisTemplate.opsForValue().set(key, value);
    }

    public String getValue(String key) {
        // Retrieve a value from Redis based on the key
        return redisTemplate.opsForValue().get(key);
    }
}
