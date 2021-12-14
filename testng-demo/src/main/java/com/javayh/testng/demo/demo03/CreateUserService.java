package com.javayh.testng.demo.demo03;

import com.javayh.testng.demo.UserEntity;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-12-10
 */
public class CreateUserService {

    public void create(UserEntity entity) {
        if (entity.getId() == null) {
            throw new RuntimeException("id is null");
        }
        System.out.println(entity.toString());
    }
}
