package com.soft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 17:00
 * @Description:
 */
@MapperScan("com.*.mapper")
@SpringBootApplication
public class RedisServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisServerApplication.class, args);
    }

}
