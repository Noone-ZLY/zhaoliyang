package com.zly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.zly.mapper")
@ComponentScan(basePackages = {"com.zly.service", "com.zly.mapper"})
public class SpringBootDemoMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoMybatisApplication.class, args);
    }
}
