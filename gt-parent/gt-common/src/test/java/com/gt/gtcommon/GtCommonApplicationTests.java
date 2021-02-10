package com.gt.gtcommon;

import com.gt.gtcommon.util.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GtCommonApplicationTests {

    @Autowired
    private RedisUtils redisUtils;
    @Test
    void contextLoads() {
        String s = null;
        try {
            s = redisUtils.get("hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("s = " + s);
    }

}
