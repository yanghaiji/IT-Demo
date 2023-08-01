package com.javayh.websocket.simp.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-08-01
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public void test() {
        try {
            int num = 1 / 0;
        } catch (Exception e) {
            log.error("执行异常 {},详细信息为 {} ", e.getMessage(), e);
        }


    }
}
