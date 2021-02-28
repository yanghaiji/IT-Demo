package com.javayh.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *      测试生产与消费 一对一打印
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-22
 */
public class ProdComTest {

    public static final int INT = 100;

    public static void main(String[] args) {
        ServerCondition serverCondition = new ServerCondition();
        new Thread("t"){
            @Override
            public void run() {
                for (int i = 0; i < INT; i++) {
                    serverCondition.set();
                }
            }
        }.start();
        new Thread("t"){
            @Override
            public void run() {
                for (int i = 0; i < INT; i++) {
                    serverCondition.get();
                }
            }
        }.start();
    }
}

class ServerCondition{
    Lock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();
    boolean flag = false;

    public void set() {
        lock.lock();
        try {
            while (flag == true){
                condition.await();
            }
            System.out.println("打印😀");
            flag = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void get(){
        lock.lock();
        try {
            while (flag == false){
                condition.await();
            }
            System.out.println("打印😳");
            flag = false;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
