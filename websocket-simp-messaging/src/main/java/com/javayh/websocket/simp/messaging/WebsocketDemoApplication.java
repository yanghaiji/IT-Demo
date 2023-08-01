package com.javayh.websocket.simp.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author haiji
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "com.javayh.websocket.simp.messaging")
public class WebsocketDemoApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(WebsocketDemoApplication.class, args);
        while (true) {
            Thread.sleep(5000);
            new Thread(() -> {
                log.info(Thread.currentThread().getName(), "正在运行");
            }).start();


        }
    }


}





