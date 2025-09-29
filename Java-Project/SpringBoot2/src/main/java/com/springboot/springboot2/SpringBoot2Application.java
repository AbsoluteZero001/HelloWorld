package com.springboot.springboot2;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.springboot2.mapper")
public class SpringBoot2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2Application.class, args);
    }
}
