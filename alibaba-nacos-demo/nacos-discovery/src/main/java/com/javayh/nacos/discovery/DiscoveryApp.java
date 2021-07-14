package com.javayh.nacos.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 服务注册与发现
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-01
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class DiscoveryApp {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApp.class,args);
    }


    //实例化 RestTemplate 实例
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
