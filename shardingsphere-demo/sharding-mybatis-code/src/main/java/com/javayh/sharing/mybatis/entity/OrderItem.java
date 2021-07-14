package com.javayh.sharing.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private Integer orderId;
    private Integer productId;
    private String productName;
    private BigDecimal price;
    private BigDecimal discount;
    private int count;
}
