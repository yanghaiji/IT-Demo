package com.javayh.tenant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javayh.tenant.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * </p>
 * @author haiji
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 自定义SQL：默认也会增加多租户条件
     * 参考打印的SQL
     * @return
     */
    Integer myCount();

    List<User> getUserAndAddr(@Param("username") String username);

    List<User> getAddrAndUser(@Param("name") String name);
}