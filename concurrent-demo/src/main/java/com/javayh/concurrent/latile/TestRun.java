package com.javayh.concurrent.latile;


/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
public class TestRun {

    public static void main(String[] args) {
        /**
         * 结果并没有达到预期，volatile 只是增加了线程的可见性，但是无法保证原子性，
         * 如果想达到结果，可以使用 synchronized 进行加持 ，实现 线程同步，变量的可见性
         *
         * 更简便的做法是将基本类型换成 Atomic下的类，进行原子操作
         *
         */
        Run[] runs = new Run[100];
        for (int i = 0; i < 100; i++) {
            runs[i] = new Run();
        }
        for (int i = 0; i < 100; i++) {
            runs[i].start();
        }

    }
}

class Run extends Thread{
    volatile public static int num =100;
    /*synchronized*/ private static void add(){
        for (int i = 0; i < 100; i++) {
            num++ ;
        }
        System.out.println("num = "+num);
    }

    @Override
    public void run() {
        add();
    }
}
