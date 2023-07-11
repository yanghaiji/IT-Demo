package com.javayh.hystrix.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-07-11
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class HystrixApp {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApp.class, args);
    }
}
