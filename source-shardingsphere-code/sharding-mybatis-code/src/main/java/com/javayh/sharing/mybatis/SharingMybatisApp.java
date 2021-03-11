package com.javayh.sharing.mybatis;

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
 * @since 2021-03-09
 */
@MapperScan(basePackages = "com.javayh.sharing.mybatis.*")
@SpringBootApplication
public class SharingMybatisApp {
    public static void main(String[] args) {
        SpringApplication.run(SharingMybatisApp.class,args);
    }
}
