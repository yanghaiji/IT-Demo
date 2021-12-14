package com.javayh.testng.demo.demo01;

import org.testng.Assert;
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
public class HelloWord {

    @Test()
    public void testEmailGenerator() {
        RandomEmailGenerator obj = new RandomEmailGenerator();
        String email = obj.generate();

        Assert.assertNotNull(email);
        Assert.assertEquals(email, "yanghaij327@163.com");

    }

}
