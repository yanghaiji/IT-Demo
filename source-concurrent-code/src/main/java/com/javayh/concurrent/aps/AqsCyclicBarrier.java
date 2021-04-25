package com.javayh.concurrent.aps;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-22
 */
@Slf4j
public class AqsCyclicBarrier {

    /**
     * CyclicBarrier 记录线程执行的个数，当达到构造的方法内的指定线程的个数才能释放
     *      并且回调执行
     *      如果 线程数量小于构造参数的数量将一直等待
     */
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(25,() -> {
        log.info("callback is running");
    });

    public static void main(String[] args) throws Exception{

        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception: {}",e);
                }
            });
        }

        executorService.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready",threadNum);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException  | BrokenBarrierException e) {
            log.error("exception: {}",e);
        }
        log.info("{} is continue",threadNum);
    }
}
