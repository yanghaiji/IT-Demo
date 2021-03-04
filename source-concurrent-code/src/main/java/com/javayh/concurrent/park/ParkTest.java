package com.javayh.concurrent.park;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-03
 */
@Slf4j
public class ParkTest {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 这与object 的wait notify notifyAll 的实现效果一样
         * 但是 这里的调用不分先后顺序 而 object 的方法则不同
         */
        Thread thread = new Thread("td") {
            @SneakyThrows
            @Override
            public void run() {
                log.debug("start");
                sleep(1000);
                LockSupport.park();
                log.debug("park");
            }
        };
        thread.start();
        sleep(2000);
        log.debug("unpark");
        LockSupport.unpark(thread);
    }
}
