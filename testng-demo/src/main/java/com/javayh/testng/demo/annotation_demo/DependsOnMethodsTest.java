package com.javayh.testng.demo.annotation_demo;

import org.testng.Assert;
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
public class DependsOnMethodsTest {

    private String msg = null;

    @Test(description = "serverStartedOk")
    public void serverStartedOk() {
        msg = "有着强依赖关系,serverStartedOk 执行强于 method1";
    }

    @Test(dependsOnMethods = {"serverStartedOk"},description = "强依赖method1")
    public void method1() {
        Assert.assertNotNull(msg);
    }

    @Test(groups = {"init"})
    public void serverStartedOk2() {
    }

    @Test(groups = {"init"})
    public void initEnvironment() {
    }

    @Test(dependsOnGroups = {"init.*"})
    public void method2() {
    }


}
