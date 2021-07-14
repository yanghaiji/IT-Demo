package com.javayh.concurrent.sync;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  防止脏读测试
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
public class DirtyReadingTest {
    /**
     * 当主线程休眠的时间小于 DirtyReading 休眠时间就会出现脏读
     *      [main] DEBUG com.javayh.concurrent.sync.PublishVar - name = [haiji], pwd = [admin321]
     *      [Dirty Reading] DEBUG com.javayh.concurrent.sync.PublishVar - name = [haiji], pwd = [haiji]
     *
     * 如何避免呢？
     *      当然可以增加主线程的休眠时间，但是这不是可取的操作
     *      正确的做法是在 getValue的方式上添加 synchronized ，实现方法的同步
     */
    public static void main(String[] args) throws InterruptedException{
        PublishVar publishVar = new PublishVar();
        ThreadA threadA = new ThreadA(publishVar);
        threadA.start();
        Thread.sleep(300);
        publishVar.getValue();
    }
}
@Slf4j
class PublishVar{
    public String name = "admin";
    public String pwd = "admin321";

    public synchronized void setValue(String name,String pwd) throws InterruptedException {
        this.name =name;
        Thread.sleep(2000);
        this.pwd =pwd;

        log.debug("name = [{}], pwd = [{}]",name,pwd);
    }

    public /*synchronized*/ void getValue(){
        log.debug("name = [{}], pwd = [{}]",name,pwd);
    }
}

class ThreadA extends Thread{

    private PublishVar publishVar;

    public ThreadA(PublishVar publishVar) {
        super("Dirty Reading");
        this.publishVar = publishVar;
    }

    @SneakyThrows
    @Override
    public void run() {
        publishVar.setValue("haiji","haiji");
    }

}


