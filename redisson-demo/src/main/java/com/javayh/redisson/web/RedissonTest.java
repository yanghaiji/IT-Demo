package com.javayh.redisson.web;

import org.redisson.api.RAtomicLong;
import org.redisson.api.RFuture;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-09
 */
@RestController
public class RedissonTest {

    @Autowired
    private RedissonClient client;

    @GetMapping(value = "lock")
    public void lock(){
        RLock lock = client.getLock("lock");
        lock.lock(30, TimeUnit.SECONDS);
        try {
            System.out.println("123456789");
            TimeUnit.SECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

//    public void getAtomicLong(){
//        RAtomicLong longObject = client.getAtomicLong("myLong");
//        // 同步执行方式
//        longObject.compareAndSet(3, 401);
//        // 异步执行方式
//        RFuture<Boolean> result = longObject.compareAndSetAsync(3, 401);
//    }


}
