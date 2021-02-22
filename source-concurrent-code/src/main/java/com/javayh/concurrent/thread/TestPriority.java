package com.javayh.concurrent.thread;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-18
 */
public class TestPriority {
    public static void main(String[] args) {
        Runnable task01 = new Runnable() {
            int count =0;
            @Override
            public void run() {
                for(;;){
                    System.out.println("task01 count--->" + count++);
                }
            }
        };

        Runnable task02 = new Runnable() {
            int count =0;
            @Override
            public void run() {
                for(;;){
                    //Thread.yield();
                    System.out.println("                task02 count--->" + count++);
                }
            }
        };

        Thread thread01 = new Thread(task01, "task01");
        Thread thread02 = new Thread(task02, "task02");

        // 设置线程的优先级 , 数值越大 优先级越高
        // yield  Priority 只是给操作系统一个提示，但是无法做到绝对，最终有系统的调度器决定
        thread01.setPriority(Thread.MIN_PRIORITY);
        thread02.setPriority(Thread.MAX_PRIORITY);

        // 启动线程
        thread01.start();
        thread02.start();

    }
}
