package com.javayh.flume.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-15
 */
@Slf4j
@RestController
@RequestMapping(value = "/flume/")
public class FlumeController {

    @GetMapping
    public String flume(){
        for (int i = 0; i < 10; i++) {
            log.info("test flume {}",i);
        }
        return "flume";
    }
}
