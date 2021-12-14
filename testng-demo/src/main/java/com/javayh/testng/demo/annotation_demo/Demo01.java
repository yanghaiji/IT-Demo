package com.javayh.testng.demo.annotation_demo;

import com.javayh.testng.demo.UserEntity;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-12-13
 */
public class Demo01 {

    /**
     * 在该套件的所有测试都运行在注释的方法之前，仅运行一次。
     */
    @BeforeSuite
    public UserEntity createUser() {
        return new UserEntity(1213L, "yanghaiji", "tghjksvls934ncAS");
    }

    @AfterSuite
    public void log() {
        System.out.println("结束。。。。" + createUser().toString());
    }

    /**
     * 异常预测
     */
    @Test(expectedExceptions = ArithmeticException.class,description = "异常预测测试")
    public void expectedExceptions() {
        int i = 1 / 0;
        System.out.println("After division the value of i is :" + i);
    }

    /**
     * 忽略测试，默认为非忽略的
     */
    @Test(enabled = false)
    public void enabled() {
        System.out.println("输出不出来");
    }

    /**
     * 异常超时测试
     * @throws InterruptedException
     */
    @Test(timeOut = 1000,description = "异常超时测试")
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2000);
    }


}
