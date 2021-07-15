package com.javayh.concurrent.lock;

import java.util.concurrent.locks.Condition;
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
public class ConditionAllTest {
    public static void main(String[] args) throws InterruptedException {
        ConditionAllServer server = new ConditionAllServer();
        new Thread("td-01"){
            @Override
            public void run() {
                server.awaitA01();
            }
        }.start();

        new Thread("td-02"){
            @Override
            public void run() {
                server.awaitA02();
            }
        }.start();
        Thread.sleep(3000);
        server.signalA();
    }
}

class ConditionAllServer {
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();

    public void awaitA01() {
        lock.lock();
        try {
            System.out.println("await conditionA start" + ">>>>>" + (System.currentTimeMillis()));
            conditionA.await();
            System.out.println("await conditionA end" + ">>>>>" + (System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitA02() {
        lock.lock();
        try {
            System.out.println("await conditionA start" + ">>>>>" + (System.currentTimeMillis()));
            conditionA.await();
            System.out.println("await conditionA end" + ">>>>>" + (System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalA() {
        lock.lock();
        try {
            System.out.println("signal" + ">>>>>>" + (System.currentTimeMillis()));
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

}