package com.gt.gtcommon.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author Zz
 * @Date 2021/2/8 14:17
 */
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 设置key及value
     */
    public void set(String key, String value) throws Exception {
        // 通过ValueOperations对象操作
        System.out.println("hello");
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置key及value和有效时间(单位为小时)
     *
     * @param key
     * @param value
     * @param timeOut
     * @throws Exception
     */
    public void setKeyValueTimeOutByHours(String key, String value, Long timeOut) throws Exception {
        // 通过ValueOperations对象操作
        stringRedisTemplate.opsForValue().set(key, value, timeOut, TimeUnit.HOURS);
    }

    /**
     * 设置key及value和有效时间(单位为秒)
     *
     * @param key
     * @param value
     * @param timeOut
     * @throws Exception
     */
    public void setKeyValueTimeOutBySecond(String key, String value, Long timeOut) throws Exception {
        // 通过ValueOperations对象操作
        stringRedisTemplate.opsForValue().set(key, value, timeOut, TimeUnit.SECONDS);
    }

    /**
     * 刷新redis中的数据的生存时间(设定的时间单位为秒)
     *
     * @param key
     * @param timeout
     */
    public void expireBySecond(String key, Long timeout) {
        stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 刷新redis中的数据的生存时间(设定的时间单位为小时)
     *
     * @param key
     * @param timeout
     */
    public void expireByHours(String key, Long timeout) {
        stringRedisTemplate.expire(key, timeout, TimeUnit.HOURS);
    }

    /**
     * 根据编号查询用户
     *
     * @param key
     * @return
     * @throws Exception
     */
    public String get(final String key) throws Exception {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 删除
     *
     * @param key
     */
    public void delete(final String key) {
        // 通过redisTeamlate对象直接操作
        stringRedisTemplate.delete(key);
    }
}
