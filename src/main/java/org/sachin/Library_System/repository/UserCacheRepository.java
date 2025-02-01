package org.sachin.Library_System.repository;

import org.sachin.Library_System.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class UserCacheRepository{

    // redistemplate
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${redis.user.details.timeout}")
    private int timeout;

    private static String userKey = "user::";

    public User getUser(String email){
        String key = userKey+email;
        return (User) redisTemplate.opsForValue().get(key);
    }

    public void setUser(String email, User user){
        String key = userKey+email;
        redisTemplate.opsForValue().set(key,user, timeout, TimeUnit.HOURS);
    }


}
