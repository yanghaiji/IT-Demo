package com.javayh.concurrent.threadlocal;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-20
 */
@Slf4j
public class InheritableThreadLocalTest {
    public static void main(String[] args) {
        /**
         * InheritableThreadLocal
         * 子线程可以取出父线程的值，但是当子线程取值是父线程的值可能回改变，取得的值是旧值
         */
        for (int i = 0; i < 10; i++) {
            log.debug("父线程: "+InheritableTools.local.get());
        }
        /**
         * 这里采用自定义的方式，InheritableThreadLocal 里有一个childValue 方法，可以对子线程进行操作
         */
        MyInheritableThread thread = new MyInheritableThread();
        thread.start();
    }
}

class InheritableTools{
    static MyInheritableThreadLocal local = new MyInheritableThreadLocal();
}

class MyInheritableThreadLocal extends InheritableThreadLocal{

    @Override
    protected Object childValue(Object parentValue) {
        return super.childValue(parentValue + "--->子线程");
    }

    @Override
    protected Object initialValue() {
        return System.currentTimeMillis();
    }
}
@Slf4j
class MyInheritableThread extends Thread{
    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            log.debug("赋值为 --"+InheritableTools.local.get());
            Thread.sleep(100);
        }
    }
}
