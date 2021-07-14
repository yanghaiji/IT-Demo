package com.javayh.concurrent.rwl;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-22
 */
public class ReadWriteTest {
    public static void main(String[] args) {
        /*
         *
         * ReentrantReadWriteLock 是一个读写锁，也就是说 他有两把锁
         * lock.readLock();
         *      这是一个读锁，也是一把共享锁
         * lock.writeLock();
         *      这是一个排他锁
         *
         */

        DemoReadLock lock = new DemoReadLock();
        // 演示读锁
        new Thread("td-read-01"){
            @SneakyThrows
            @Override
            public void run() {
                lock.read();
            }
        }.start();
        new Thread("td-read-02"){
            @SneakyThrows
            @Override
            public void run() {
                lock.read();
            }
        }.start();

        //演示写锁 互斥锁
        new Thread("td-write-02"){
            @SneakyThrows
            @Override
            public void run() {
                lock.write();
            }
        }.start();
        new Thread("td-write-01"){
            @SneakyThrows
            @Override
            public void run() {
                lock.write();
            }
        }.start();
    }
}

class DemoReadLock{
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    /**
     * 读锁时共享锁
     */
    public void read() throws InterruptedException {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"--->"+System.currentTimeMillis());
            Thread.sleep(1000);
        } finally {
            lock.readLock().unlock();
        }

    }

    /**
     * 演示写锁 互斥锁
     * @throws InterruptedException
     */
    public void write() throws InterruptedException {
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"--->"+System.currentTimeMillis());
            Thread.sleep(1000);
        } finally {
            lock.writeLock().unlock();
        }

    }
}
