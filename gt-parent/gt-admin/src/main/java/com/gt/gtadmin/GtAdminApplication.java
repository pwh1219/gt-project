package com.gt.gtadmin;


import com.gt.gtcommon.util.RedisKey;
import com.gt.gtcommon.util.RedisUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class GtAdminApplication {

    @Bean
    public RedisUtils getRedisUtils() {
        return new RedisUtils();
    }

    @Bean
    public RedisKey getRedisKey() {
        return new RedisKey();
    }
    public static void main(String[] args) {
        SpringApplication.run(GtAdminApplication.class, args);
    }

}
