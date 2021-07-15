package com.javayh.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Condition 实现线程的等待，唤醒
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-20
 */
public class ConditionTest {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 在使用 synchronized 时 我们可以通过 wait notify notifyAll 实现通信
         * 使用Lock 时我们可以借助 Condition 实现通信
         */
        ConditionServer conditionServer = new ConditionServer();
        new Thread("td"){
            @Override
            public void run() {
                conditionServer.await();
            }
        }.start();
        Thread.sleep(3000);
        conditionServer.signal();
    }
}

class ConditionServer {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void await() {
        lock.lock();
        try {
            System.out.println("await" + ">>>>>" + (System.currentTimeMillis()));
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        lock.lock();
        try {
            System.out.println("signal" + ">>>>>>" + (System.currentTimeMillis()));
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
