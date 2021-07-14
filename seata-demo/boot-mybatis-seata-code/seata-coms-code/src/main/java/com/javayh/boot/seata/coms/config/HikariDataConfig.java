//package com.javayh.boot.seata.coms.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.zaxxer.hikari.HikariDataSource;
//import io.seata.rm.datasource.DataSourceProxy;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * <p>
// *
// * </p>
// *
// * @author Dylan
// * @version 1.0.0
// * @since 2021-03-23
// */
//@Configuration
//public class HikariDataConfig {
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource() {
//        HikariDataSource hikariDataSource = new HikariDataSource();
//        DataSourceProxy proxy = new DataSourceProxy(hikariDataSource);
//        return proxy;
//    }
//
//}
