package com.javayh.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * nacos config
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-01
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApp.class, args);
    }
}
