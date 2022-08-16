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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author haiji
 */
@org.springframework.context.annotation.Configuration
@MapperScan(basePackages = "com.javayh.multiple.mybatis.two.dao", sqlSessionTemplateRef = "twoSqlSessionTemplate")
public class TwoMybatisConfigData {

    @Bean("twoSqlSessionFactory")
    public SqlSessionFactory twoSqlSessionFactory(@Qualifier("dsTwo") HikariDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        Configuration configuration = new Configuration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setLogPrefix("two-sqlSession-template");
        configuration.setUseColumnLabel(true);
        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/two/*.xml"));
        return sqlSessionFactory.getObject();
    }

    @Bean(name = "twoTransactionManager")
    public DataSourceTransactionManager twoTransactionManager(@Qualifier("dsTwo") HikariDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "twoSqlSessionTemplate")
    public SqlSessionTemplate twoSqlSessionTemplate(@Qualifier("twoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}