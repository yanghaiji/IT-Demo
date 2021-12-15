package com.javayh.testng.demo.demo02;

import org.testng.annotations.Test;

/**
 * <p>
 * 异常预测测试
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-12-10
 */
public class TestRuntime {

    @Test(expectedExceptions = ArithmeticException.class)
    public void divisionWithException() {
        int i = 1 / 0;
        System.out.println("After division the value of i is :" + i);
    }
}
