package com.javayh.concurrent.signal;

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
@Slf4j
public class TestJoin {
    private static  int num =0;
    public static void main(String[] args) throws InterruptedException {
//        test01();
        test02();
    }

    private static void test01() throws InterruptedException {
        log.debug("开始");
        Thread thread = new Thread("td") {
            @SneakyThrows
            @Override
            public void run() {
                log.debug("开始");
                sleep(1);
                log.debug("结束");
                num = 10;
            }
        };
        thread.start();
        // 线程等待， 只要 td 的线程全部执行完，才会继续向下执行，否则一直等待
        // 进而实现线程的同步
        thread.join();
        log.debug("num 的结果为: " + num);
        log.debug("结束");
    }

    private static void test02() throws InterruptedException {
        log.debug("开始");
        Thread thread = new Thread("td") {
            @SneakyThrows
            @Override
            public void run() {
                log.debug("开始");
                sleep(2);
                log.debug("结束");
                num = 10;
            }
        };
        thread.start();
        // 当线程等待 1 秒后继续执行，这是 td 还处于sleep状态，最总的num 没有被修改
        // 如果 join 内的时间大于线程执行的时间 则以最短时间为基准
        thread.join(1);
        log.debug("num 的结果为: " + num);
        log.debug("结束");
    }
}
