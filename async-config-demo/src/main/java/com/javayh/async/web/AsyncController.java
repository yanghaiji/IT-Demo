package com.javayh.async.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
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
 * @since 2022-11-29
 */
@Slf4j
@RestController
@RequestMapping("test")
public class AsyncController {

    @Async
    @GetMapping("demo01")
    public void demo01(){
        log.info("demo01处理.......");
    }


    @Async("asyncExecutor01")
    @GetMapping("demo02")
    public void demo02(){
        log.info("demo02处理.......");
    }


    @Async("asyncExecutor02")
    @GetMapping("demo03")
    public void demo03(){
        log.info("demo32处理.......");
    }
}
