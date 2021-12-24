package com.javayh.skywalking.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-12-24
 */
@RestController
public class SkywalkingDemoWeb {

    @GetMapping
    public String getMapping() {
        return "SkywalkingApp";
    }
}
