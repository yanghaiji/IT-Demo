package com.javayh.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-20
 */
public class LockTest01 {
    public static void main(String[] args) {
        /**
         * ReentrantLock 替换 synchronized 实现同步
         * ReentrantLock 也是对象级别的锁
         */
        LockServer lockServer = new LockServer();
        new Thread("01"){
            @Override
            public void run() {
                lockServer.out();
            }
        }.start();

        new Thread("02"){
            @Override
            public void run() {
                lockServer.out();
            }
        }.start();

        new Thread("03"){
            @Override
            public void run() {
                lockServer.out();
            }
        }.start();
    }
}

class LockServer{
    private Lock lock = new ReentrantLock();
    public void out(){
        //获取锁
        lock.lock();
        try{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+ "-----" + (i+1));
            }
        } finally{
            // 释放锁
            lock.unlock();
        }
    }
}
