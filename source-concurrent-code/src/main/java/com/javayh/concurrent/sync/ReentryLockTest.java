package com.javayh.concurrent.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 测试 synchronized 的可重入性
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
public class ReentryLockTest {

    /**
     * synchronized 是可重入锁
     *  可重入锁指的是自己可以获取自己内部的锁
     *      比如一个线程获取了某个对象的锁，此时这个对象的锁并没释放，当再次进行获取锁时，
     *      如果不可重入，就会进行死锁，可重入锁也支持父子类的继承
     */
    public static void main(String[] args) {

        new Thread("td"){
            @Override
            public void run() {
                SyncServer syncServer = new SyncServer();
                syncServer.get01();
            }
        }.start();
    }
}

class SyncServer{

    synchronized public void get01(){
        System.out.println("-----> 01");
        get02();
    }

    synchronized public void get02(){
        System.out.println("-----> 02");
        get03();
    }

    synchronized public void get03(){
        System.out.println("-----> 03");
    }
}
