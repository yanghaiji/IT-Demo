package com.javayh.hystrix.demo;

import com.javayh.hystrix.demo.service.Example1Service;
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
 * @since 2023-07-11
 */
@RestController
@RequestMapping(value = "hystrix-demo/")
public class ExampleController {

    @Autowired
    private Example1Service example1Service;

    @GetMapping(value = "example01")
    public Integer example01() {
        return example1Service.example01();
    }


    @GetMapping(value = "example02")
    public void example02() {
        example1Service.example02();
    }
}
