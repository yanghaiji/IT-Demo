package com.javayh.tenant.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023/3/15
 */
@Data
@Accessors(chain = true)
@TableName("sys_user")
public class User {
    private Long id;
    /**
     * 租户 ID
     */
    private Long tenantId;
    private String name;

    @TableField(exist = false)
    private String addrName;

}