package com.javayh.sharing.mybatis.dao;

import com.javayh.sharing.mybatis.entity.Order;
import com.javayh.sharing.mybatis.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-09
 */
@Mapper
public interface OrderMapper {

    void insert(Order order);

    void insertItem(OrderItem orderItem);
}
