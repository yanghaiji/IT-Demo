package com.javayh.mybatis.controller;

import com.javayh.mybatis.dao.MybatisDao;
import com.javayh.mybatis.vo.LogisticsVO;
import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-08
 */
@RestController
@RequestMapping(value = "/mybatis/")
public class MybatisController {

    @Autowired
    private MybatisDao dao;

    @SneakyThrows
    @GetMapping(value = "name")
    public List<?> findAllName(){
       /* String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Object o = sqlSession.selectOne("");*/
        return dao.findAllName();
    }

    @GetMapping(value = "all")
    public List<?> findAll(){
        return dao.findListAndIf(new ArrayList<>());
    }

}
