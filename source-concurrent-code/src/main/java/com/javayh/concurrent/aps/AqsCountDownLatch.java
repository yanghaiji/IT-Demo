package com.javayh.concurrent.aps;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * <p>
 *  闭锁扣除点
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-22
 */
@Slf4j
public class AqsCountDownLatch {

    public static final int SIZE = 20;
    public static final int  COUNT = 100;
    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 20个闭锁扣除点 扣除完毕后，主线程和业务线程才能继续执行
        final CountDownLatch countDownLatch = new CountDownLatch(COUNT);
        for (int i = 0; i < SIZE; i++) {
            int threadNum = i;
            executorService.execute(()->{
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                    log.debug("getCount 剩余数量 --> {}",countDownLatch.getCount());
                }
            });
        }
        log.debug("创建用户 --> {}",countDownLatch.getCount());
        //如果这里不指定 等待的时间，COUNT > SIZE 将一直等待下去
        countDownLatch.await(3000, TimeUnit.MICROSECONDS);
        //countDownLatch.await();
        log.debug("创建用户结束 <-- {}",countDownLatch.getCount());
        executorService.shutdown();
    }


    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        log.info("用户名 : admin{}",threadNum+1);
        Thread.sleep(1000);
    }
}
