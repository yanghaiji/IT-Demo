package com.javayh.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *      线程的打断
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-18
 */
@Slf4j
public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread td = new Thread("td") {
            @Override
            public void run() {
                try {
                    log.debug("td sleep");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log.debug("td  wake up");
                    e.printStackTrace();

                }
            }
        };
        td.start();
        Thread.sleep(100);
        log.debug("td interrupt");
        //判断线程是否中断
        boolean interrupted = td.isInterrupted();
        log.debug("td interrupted stats :[{}]",interrupted);
        td.interrupt();


    }
}
