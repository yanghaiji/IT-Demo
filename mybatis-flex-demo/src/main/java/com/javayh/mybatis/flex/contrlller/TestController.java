package com.javayh.mybatis.flex.contrlller;

import com.javayh.mybatis.flex.mapper.UserMapper;
import com.javayh.mybatis.flex.pojo.User;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-08-10
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/add")
    public void add() {
        User user = new User();
        user.setEmail("test@qq.com");
        user.setName("haiji");
        userMapper.insert(user);
    }

    @GetMapping(value = "/findAll")
    public void findAll() {
        List<User> userList = userMapper.selectAll();
        System.out.println(userList);
    }

    @GetMapping(value = "/like")
    public void like() {
        QueryWrapper from = QueryWrapper.create().select().from(User.class);
        List<User> users = userMapper.selectListByQuery(from);
    }

}
