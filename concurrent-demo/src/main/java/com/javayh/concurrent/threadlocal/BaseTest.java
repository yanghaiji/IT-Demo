package com.javayh.concurrent.threadlocal;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *      验证线程之间变量的隔离性
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-20
 */
@Slf4j
public class BaseTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
        for (int i = 0; i < 100; i++) {
            Tools.local.set("赋值为：" +(i+1));
            log.debug("数据为："+ Tools.local.get());
            Thread.sleep(200);
        }
    }
}

class Tools{
    static ThreadLocal<String> local = new ThreadLocal<>();
}

@Slf4j
class ThreadA extends Thread{
    public ThreadA() {
        super("ThreadA");
    }
    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Tools.local.set("赋值为：" +(i+1));
            log.debug("数据为："+ Tools.local.get());
            Thread.sleep(200);
        }
    }
}

@Slf4j
class ThreadB extends Thread{
    public ThreadB() {
        super("ThreadB");
    }
    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Tools.local.set("赋值为：" +(i+1));
            log.debug("数据为："+ Tools.local.get());
            Thread.sleep(200);
        }
    }
}
