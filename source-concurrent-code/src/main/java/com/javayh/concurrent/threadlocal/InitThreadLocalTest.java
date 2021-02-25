package com.javayh.concurrent.threadlocal;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 验证自定义ThreadLocal初始值
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-20
 */
@Slf4j
public class InitThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        /**
         * ThreadLocal 默认的初始值是 null
         * 如果想更改 器初始值，重写 initialValue 方法即可
         */
        ThreadLocal threadLocal = new ThreadLocal();
        System.out.println(threadLocal.get());
        //自定义 ThreadLocal
        MyThreadLocal myThreadLocal = new MyThreadLocal();
        System.out.println(myThreadLocal.get());

        /**
         *  验证 自定义的 ThreadLocal 线程的隔离性
         */
        MyThreadA threadA = new MyThreadA();
        MyThreadB threadB = new MyThreadB();
        threadA.start();
        threadB.start();
        for (int i = 0; i < 10; i++) {
            log.debug("数据为：" + MyTools.local.get());
            Thread.sleep(200);
        }
    }
}

class MyThreadLocal extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return System.currentTimeMillis();
    }

}

class MyTools {
    static MyThreadLocal local = new MyThreadLocal();
}

@Slf4j
class MyThreadA extends Thread {
    public MyThreadA() {
        super("MyThreadA");
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            log.debug("数据为：" + MyTools.local.get());
            Thread.sleep(200);
        }
    }
}

@Slf4j
class MyThreadB extends Thread {
    public MyThreadB() {
        super("MyThreadB");
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            log.debug("数据为：" + MyTools.local.get());
            Thread.sleep(200);
        }
    }
}
