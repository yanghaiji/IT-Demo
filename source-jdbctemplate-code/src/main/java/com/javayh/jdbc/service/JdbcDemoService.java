package com.javayh.jdbc.service;

import com.javayh.jdbc.entity.Demo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-08
 */
@Service
public class JdbcDemoService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    String INSERT_DEMO = "INSERT INTO demo (name ,pwd) VALUES (?,?);";
    String UPDATE_DEMO = "UPDATE demo SET name =? ,pwd =?  WHERE id = ?;";
    String DELETE_DEMO = "DELETE FROM demo WHERE id = ?;";
    String SELECT_COUNT = "SELECT COUNT(*) FROM demo;";
    String SELECT = "SELECT * FROM demo WHERE id =?;";
    String SELECT_ALL = "SELECT * FROM demo;";

    /**
     * 保存
     * @param name  名字
     * @param pwd   密码
     * @return int
     */
    public int save(String name, String pwd){
        return jdbcTemplate.update(INSERT_DEMO, name, pwd);
    }

    /**
     * 根据id 进行更新
     * @param name
     * @param pwd
     * @param id
     * @return
     */
    public int update(String name, String pwd,Integer id){
        return jdbcTemplate.update(UPDATE_DEMO, name, pwd,id);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id){
        return jdbcTemplate.update(DELETE_DEMO, id);
    }




}