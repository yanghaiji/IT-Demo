package com.javayh.concurrent.aps;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-23
 */
@Slf4j
public class JucCompletableFuture {

    public static final int NUM = 100;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<Integer> asyncSum = new CompletableFuture<>();
        for (int i = 0; i < NUM; i++) {
            asyncSum = CompletableFuture.supplyAsync(() -> {
                int sum = 0;
                for (int j = 0; j < NUM; j++) {
                    sum += j;
                }
                log.debug("sum = {}", sum);

                return sum;
            }, executorService);
        }

        /*
         * 计算异常后的处理
         */
        CompletableFuture<Integer> sum_error = asyncSum.exceptionally((throwable) -> {
            log.error("求和失败-线程name:{},----线程ID:{},异常原因:{}",
                    Thread.currentThread().getName(), Thread.currentThread().getId(),
                    throwable.getCause());
            throw new RuntimeException("sum error");
        });

        /*
         * 成功后需要做的操作，如果没有其他的附加操作 可以直接返回
         */
        CompletableFuture<Integer> async = asyncSum.thenApplyAsync((result) -> {
            log.debug("sum = {}", result);
            return result + 100;
        });
        log.debug("最终的 sum = {}", async.join());

    }
}
