package com.javayh.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-08
 */
@MapperScan(basePackages = "com.javayh.mybatis.*")
@SpringBootApplication
public class MybatisApp {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApp.class,args);
    }
}
