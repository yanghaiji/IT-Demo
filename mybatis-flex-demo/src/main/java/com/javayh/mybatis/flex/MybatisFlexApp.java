package com.javayh.mybatis.flex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-08-10
 */

@MapperScan("com.javayh.mybatis.flex.mapper")
@SpringBootApplication
public class MybatisFlexApp {

    public static void main(String[] args) {
        SpringApplication.run(MybatisFlexApp.class, args);
    }
}
