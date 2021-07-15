//package com.javayh.boot.seata.prod.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import io.seata.rm.datasource.DataSourceProxy;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
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
//    public DataSource hikariDataSource() {
//        DataSource datasource = new HikariDataSource();
//        return new DataSourceProxy(datasource);
//    }
//}
