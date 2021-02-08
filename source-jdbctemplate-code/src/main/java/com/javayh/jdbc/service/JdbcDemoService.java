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

    /**
     * 查询总条数
     * @param id
     * @return
     */
    public Integer query(Integer id){
        return jdbcTemplate.queryForObject(SELECT_COUNT,Integer.class);
    }

    /**
     * 查询实体
     * @param id
     * @return
     */
    public Demo queryDemo(Integer id){
        return jdbcTemplate.queryForObject(SELECT, (resultSet, i) -> {
            int id1 = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String pwd = resultSet.getString("pwd");
            Demo demo = new Demo();
            demo.setId(id1);
            demo.setName(name);
            demo.setPwd(pwd);
            return demo;
        },id);
    }

    /**
     * 查询实体集合
     * @return
     */
    public List<Demo> queryAll(){
        return jdbcTemplate.query(SELECT_ALL,new BeanPropertyRowMapper<>(Demo.class));
    }



}