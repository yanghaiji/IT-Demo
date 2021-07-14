package com.javayh.concurrent.sync;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
public class SyncTest {


    public static void main(String[] args) {
        SyncA syncA = new SyncA();
        // 这是两把锁，互不影响
        syncA.setObject();
        syncA.setString();
    }
}

class SyncA{

    Object object = new Object();
    String string = new String();

    /**
     * 锁方法
     */
    public synchronized void get(){

    }

    /**
     * 锁代码块
     */
    public synchronized void set(){

        synchronized(this){
            for (int i = 0; i < 10; i++) {

            }
        }
    }

    public synchronized void add(){

        synchronized(SyncA.class){
            for (int i = 0; i < 10; i++) {

            }
        }
    }

    /**
     * 锁指定的对象， Object String 。。。
     */
    public synchronized void setObject(){

        synchronized(object){
            for (int i = 0; i < 10; i++) {

            }
        }
    }

    public synchronized void setString(){

        synchronized(string){
            for (int i = 0; i < 10; i++) {

            }
        }
    }

}
