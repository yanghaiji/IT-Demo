package com.javayh.jdbc.controller;

import com.javayh.jdbc.entity.Demo;
import com.javayh.jdbc.service.JdbcDemoService;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class JdbcDemoController {

    @Resource
    private JdbcDemoService jdbcDemoService;

    /**
     * 保存
     * @param name
     * @param pwd
     * @return
     */
    @PostMapping(value = "save")
    public int save(String name, String pwd){
        return jdbcDemoService.save(name, pwd);
    }

    /**
     * 更新
     * @param name
     * @param pwd
     * @param id
     * @return
     */
    @PostMapping(value = "update")
    public int update(String name, String pwd,Integer id){
        return jdbcDemoService.update(name, pwd,id);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping(value = "delete")
    public int delete(Integer id){
        return jdbcDemoService.delete(id);
    }




}
