package com.javayh.concurrent.sync;

import lombok.SneakyThrows;

/**
 * <p>
 *      测试方法内部的变量是否是线程安全的
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
public class TestPrivateParam {

    public static void main(String[] args) {
        /*
         * 局部变量不存在线程安全问题
         *
         * 成员变量存在线程安全问题！
         *      如何解决这个问题，可以在方法上直接添加 synchronized
         */
        PrivateParam privateParam = new PrivateParam();
        TestPrivate testPrivate = new TestPrivate(privateParam);
        testPrivate.start();
        TestPrivate02 testPrivate02 = new TestPrivate02(privateParam);
        testPrivate02.start();
    }
}

class PrivateParam{
    //作为成员(实例)变量
    int num = 0;

    @SneakyThrows
     public synchronized void add(String type){
        //作为局部变量
        //int num = 0;
        if("admin".equalsIgnoreCase(type)){
            num = 100;
            System.out.println("admin sh");
            Thread.sleep(2000);
        }else {
            num = 200;
            System.out.println("other sh");
        }
        System.out.println("num = " + num);
    }
}

class TestPrivate extends Thread{

    private PrivateParam privateParam;

    public TestPrivate(PrivateParam privateParam) {
        super("TestPrivate");
        this.privateParam = privateParam;
    }

    @Override
    public void run() {
        privateParam.add("admin");
    }
}


class TestPrivate02 extends Thread{

    private PrivateParam privateParam;

    public TestPrivate02(PrivateParam privateParam) {
        super("TestPrivate02");
        this.privateParam = privateParam;
    }

    @Override
    public void run() {
        privateParam.add("admin123");
    }
}

