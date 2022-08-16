package com.javayh.multiple.mybatis.web;

import com.javayh.multiple.mybatis.one.dao.OneDao;
import com.javayh.multiple.mybatis.two.dao.TwoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2022-08-15
 */
@RestController
@RequestMapping(value = "/test")
public class TestWeb {


    @Autowired
    private TwoDao twoDao;
    @Autowired
    private OneDao oneDao;


    @GetMapping(value = "/one")
    public String getOne() {
        return oneDao.getOne(1L);
    }


    @GetMapping(value = "/two")
    public String getTwo() {
        return twoDao.getTwo(2L);
    }

}
