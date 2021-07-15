package com.javayh.concurrent.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-18
 */
@Slf4j(topic = "td.test01")
public class TestSleep {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread("td") {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(2000);
            }
        };
        thread.start();
        log.debug(" thread stats {}", thread.getState());
        Thread.sleep(500);
        log.debug(" thread stats {}", thread.getState());
    }

}
