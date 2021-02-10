package com.gt.gtadmin;


import com.gt.gtcommon.util.RedisKey;
import com.gt.gtcommon.util.RedisUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.gt.gtadmin.mapper") //注意MapperScan要导tk的包，不然会报NoSuchMethodException
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
