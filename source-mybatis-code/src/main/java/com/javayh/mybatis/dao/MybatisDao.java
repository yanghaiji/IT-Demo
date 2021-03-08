package com.javayh.mybatis.dao;

import com.javayh.mybatis.vo.LogisticsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-08
 */
@Mapper
public interface MybatisDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select name from mybatis")
    List<String> findAllName();

    List<LogisticsVO> findListAndIf(@Param(value = "vos") List<LogisticsVO> vos);


    /**
     * 新增
     */
    void insert(String name);
}
