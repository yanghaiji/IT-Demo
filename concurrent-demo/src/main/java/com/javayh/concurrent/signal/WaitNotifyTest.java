package com.javayh.concurrent.signal;

import lombok.SneakyThrows;

/**
 * <p>
 * 线程通信
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
public class WaitNotifyTest {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        WaitTest waitTest = new WaitTest(object);
        waitTest.start();
        Thread.sleep(1000);
        NotifyTest notifyTest = new NotifyTest(object);
        notifyTest.start();
    }
}

class WaitTest extends Thread{

    private Object object;

    public WaitTest(Object object) {
        super("WaitTest");
        this.object = object;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (object){
            System.out.println("开始wait ：" + System.currentTimeMillis());
            object.wait();
            System.out.println("结束wait ：" + System.currentTimeMillis());
        }
    }
}

class NotifyTest extends Thread{

    private Object object;

    public NotifyTest(Object object) {
        super("NotifyTest");
        this.object = object;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (object){
            System.out.println("开始notify：" + System.currentTimeMillis());
            object.notify();
            System.out.println("结束notify：" + System.currentTimeMillis());
        }
    }
}
