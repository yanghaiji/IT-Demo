package com.javayh.multiple.mybatis.two.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2022-08-15
 */
@Mapper
public interface TwoDao {

    @Select("SELECT username FROM at_user WHERE user_id = #{id}")
    String getTwo(Long id);

}
