package com.javayh.multiple.mybatis.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * <p>
 * 多数据源
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2022/8/15
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.one")
    public HikariDataSource dsOne() {
        return new HikariDataSource();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.two")
    public HikariDataSource dsTwo() {
        return new HikariDataSource();
    }
}