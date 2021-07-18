package com.java.spel.web;

import com.java.spel.annotation.DemoLog;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-16
 */
@RestController
public class SpElDemo {

    @DemoLog(el = "#id")
    @GetMapping(value = "spel/demo/{id}")
    public void get(@PathVariable("id") Integer id){

    }

    @DemoLog(el = "#user.name")
    @GetMapping(value = "spel/demo")
    public void get(SecurityProperties.User user){

    }
}
