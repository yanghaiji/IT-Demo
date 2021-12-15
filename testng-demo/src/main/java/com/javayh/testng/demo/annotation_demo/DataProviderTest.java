package com.javayh.testng.demo.annotation_demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-12-14
 */
public class DataProviderTest {

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{{"Cedric", 36}, {"Anne", 37},};
    }

    @Test(dataProvider = "test1",description = "dataProvider 注解测试")
    public void verifyData1(String n1, Integer n2) {
        System.out.println(n1 + " " + n2);
    }

}
