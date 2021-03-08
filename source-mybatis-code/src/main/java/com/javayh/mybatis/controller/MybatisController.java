package com.javayh.mybatis.controller;

import com.javayh.mybatis.dao.MybatisDao;
import com.javayh.mybatis.vo.LogisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "name")
    public List<?> findAllName(){
        return dao.findAllName();
    }

    @GetMapping(value = "all")
    public List<?> findAll(){
        return dao.findListAndIf(new ArrayList<>());
    }

}
