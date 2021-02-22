package com.javayh.concurrent.thread;

/**
 * <p>
 * 防止死循环倒是CPU100%
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-18
 */
public class TestSleepCpu {
    public static void main(String[] args) {
        while (true){
            // 防止死循环倒是CPU100
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("java 有货");
        }
    }
}
