package com.javayh.github.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 测试oauth2 实现GitHub授权
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-02
 */
@SpringBootApplication
public class GithubOauthApp {

    public static void main(String[] args) {
        SpringApplication.run(GithubOauthApp.class,args);
    }
}
