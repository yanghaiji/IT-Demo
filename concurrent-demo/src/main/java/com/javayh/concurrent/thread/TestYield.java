package com.javayh.concurrent.thread;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
@Slf4j
public class TestYield {

    public static void main(String[] args) {

        /**
         * yield 放弃cpu资源，让其他资源优先执行，但是也有可能刚刚放弃又重新获取资源
         */
        Thread thread = new Thread("td") {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 10000; i++) {
                    log.debug("i = {}", i);
                    Thread.yield();
                }
                long end = System.currentTimeMillis();
                log.debug("总耗时为 ：{}",end-start);
            }
        };
        thread.start();
    }
}
