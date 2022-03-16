package com.javayh.elaticsearh.controller;

import com.javayh.elaticsearh.docment.UserEntity;
import com.javayh.elaticsearh.repository.EsRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * repo 测试 repo的测试，和其他的jpa用法一样
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.elaticsearh.controller → EsRepoWeb
 * @since 2022-02-10
 */
@RequestMapping(value = "/repo")
@RestController
public class EsRepoWeb {

    @Autowired
    private EsRepoImpl esRepo;

    /**
     * <p>
     * 根据id 查询
     * </p>
     *
     * @param
     * @return void
     * @version 1.0.0
     * @author hai ji
     * @since 2022/2/10
     */
    @GetMapping
    public void get() {
        UserEntity entity = esRepo.findById(1212L).orElse(null);
        System.out.println(entity);
    }


}
