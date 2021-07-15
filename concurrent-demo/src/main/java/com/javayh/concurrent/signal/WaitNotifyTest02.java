package com.javayh.concurrent.signal;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
public class WaitNotifyTest02 {
    @SneakyThrows
    public static void main(String[] args) {
        /**
         * notifyAll 会唤醒所有的线程
         * notify 只会随机唤醒一个线程
         */
        Object object = new Object();
        WaitListTest waitTest = new WaitListTest(object);
        waitTest.start();
        WaitListTest02 waitListTest02 = new WaitListTest02(object);
        waitListTest02.start();
        Thread.sleep(1000);
        NotifyListTest notifyTest = new NotifyListTest(object);
        notifyTest.start();
    }
}

class MyList {
    static List<String> list = new ArrayList<>();

    static void add() {
        list.add("twt");
    }

    static int size() {
        return list.size();
    }
}

@Slf4j
class WaitListTest extends Thread {

    private final Object object;

    public WaitListTest(Object object) {
        super("WaitTestList");
        this.object = object;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (object) {
            if (MyList.size() != 5) {
                log.debug("开始wait ：" + System.currentTimeMillis());
                object.wait();
                log.debug("结束wait ：" + System.currentTimeMillis());
            }
        }
    }
}
@Slf4j
class WaitListTest02 extends Thread {

    private final Object object;

    public WaitListTest02(Object object) {
        super("WaitTestList02");
        this.object = object;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (object) {
            if (MyList.size() != 5) {
                log.debug("开始wait ：" + System.currentTimeMillis());
                object.wait();
                log.debug("结束wait ：" + System.currentTimeMillis());
            }
        }
    }
}
@Slf4j
class NotifyListTest extends Thread {

    private final Object object;

    public NotifyListTest(Object object) {
        super("NotifyTest");
        this.object = object;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (object) {
            for (int i = 0; i < 10; i++) {
                MyList.add();
                log.debug("添加到了第" + i +"元素");
                if(MyList.size() == 5){
                    log.debug("消息已发出,进行唤醒"+System.currentTimeMillis());
                    //object.notify();
                    object.notifyAll();
                }
                Thread.sleep(1000);
            }

        }
    }
}