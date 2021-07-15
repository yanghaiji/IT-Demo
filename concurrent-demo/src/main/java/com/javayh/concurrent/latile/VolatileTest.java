package com.javayh.concurrent.latile;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
@Slf4j
public class VolatileTest {

    /**
     * 当运行后程序无法定制，说明flag不是共享的资源
     *  如何解决同步死循环问题呢？
     *      实现 Runnable 接口, 将publishVar.print(); 注释掉。开启Thread
     */
    public static void main(String[] args) throws InterruptedException {
        PublishVar publishVar = new PublishVar();
        publishVar.print();
        //new Thread(publishVar).start();
        log.debug("我要停止循环");
        publishVar.setFlag(false);
        log.debug("停止成功");
    }
}

@Slf4j
class PublishVar /*implements Runnable*/{
    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void print() throws InterruptedException {
        while (flag == true){
            log.debug(Thread.currentThread().getName()+" 循环进行中。。。。");
            Thread.sleep(1000);
        }
    }

    /*@SneakyThrows
    @Override
    public void run() {
        print();
    }*/
}
