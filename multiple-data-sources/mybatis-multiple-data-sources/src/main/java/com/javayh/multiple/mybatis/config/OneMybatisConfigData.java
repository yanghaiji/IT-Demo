package com.javayh.multiple.mybatis.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author haiji
 */
@org.springframework.context.annotation.Configuration
@MapperScan(basePackages = "com.javayh.multiple.mybatis.one.dao", sqlSessionTemplateRef = "oneSqlSessionTemplate")
public class OneMybatisConfigData {

    @Primary
    @Bean("oneSqlSessionFactory")
    public SqlSessionFactory oneSqlSessionFactory(@Qualifier("dsOne") HikariDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        Configuration configuration = new Configuration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setLogPrefix("one-sqlSession-template");
        configuration.setUseColumnLabel(true);
        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/one/*.xml"));
        return sqlSessionFactory.getObject();
    }

    @Primary
    @Bean(name = "oneTransactionManager")
    public DataSourceTransactionManager oneTransactionManager(@Qualifier("dsOne") HikariDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "oneSqlSessionTemplate")
    public SqlSessionTemplate oneSqlSessionTemplate(@Qualifier("oneSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}