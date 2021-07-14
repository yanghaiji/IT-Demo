package com.javayh.sharing.mybatis.web;

import com.javayh.sharing.mybatis.dao.OrderMapper;
import com.javayh.sharing.mybatis.entity.Order;
import com.javayh.sharing.mybatis.entity.OrderItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-09
 */
@RestController
@RequestMapping(value = "/sharing/")
public class SharingController {
    @Resource
    private OrderMapper orderMapper;

    @GetMapping(value = "insert")
    public void insert(){
        for (int i = 1; i < 10; i++) {
            orderMapper.insert(new Order(i,i,new BigDecimal("32.90"),new BigDecimal(2398), LocalDateTime.now()));
            orderMapper.insertItem(new OrderItem(i,i,"test",new BigDecimal("32.90"),new BigDecimal(2398), i));
        }
    }
}
