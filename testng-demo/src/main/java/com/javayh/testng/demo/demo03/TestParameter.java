package com.javayh.testng.demo.demo03;

import com.javayh.testng.demo.UserEntity;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-12-10
 */
public class TestParameter {
    private UserEntity entity;

    @BeforeTest
    void setup() {
        entity = new UserEntity();
        entity.setId(11L);
        entity.setName("yanghaiji");
        entity.setPwd("yanghaiji");
    }

    //    @Test(expectedExceptions = RuntimeException.class)
    @Test(description = "demo1")
    public void test01() {
        new CreateUserService().create(entity);
        Assert.assertNotNull(entity.getId());
    }

    @Parameters({"id", "pwd"})
    @Test(testName = "test02",description = "测试动态参数1")
    public void test02(Long id, String pwd) {
        System.out.println(pwd);
        UserEntity entity = new UserEntity();
        entity.setId(id);
        System.out.println(id);
        new CreateUserService().create(entity);
        Assert.assertNotNull(entity.getId());
    }

    @Parameters({"name"})
    @Test(testName = "测试异常显示",description = "测试异常显示")
    public void test03(String name) {
        Integer.valueOf(name);
    }

}
