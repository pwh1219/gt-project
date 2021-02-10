package com.gt.gtadmin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.gt.gtadmin.mapper") //注意MapperScan要导tk的包，不然会报NoSuchMethodException
public class GtAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GtAdminApplication.class, args);
    }

}
