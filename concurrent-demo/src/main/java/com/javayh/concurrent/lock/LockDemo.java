package com.javayh.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-22
 */
public class LockDemo {
    //公平锁
    ReentrantLock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();
    public void get() {
        //尝试获取锁
        lock.tryLock();
        try {
            System.out.println("打印");
            // 查询当前线程的锁定次数
            System.out.println(lock.getHoldCount());
            // 获取正在等待此线程的个数
            // 如 : 有 5个线程 ，一个线程调用了wait 方法 ，那么这是 getQueueLength = 4
            System.out.println(lock.getQueueLength());
            // 查询指定的线程是否在等待此锁
            lock.hasQueuedThread(Test.currentThread());
            // 让线程进入等待
            condition.wait();
            // 唤醒线程
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Test extends Thread{

}
