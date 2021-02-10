package com.gt.gtcommon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gt.gtcommon.util")
public class GtCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(GtCommonApplication.class, args);
    }

}
