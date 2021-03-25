package com.javayh.boot.seata.prod.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-22
 */
@Mapper
public interface GoodsDao {

    @Update("UPDATE surplus_brand SET  brand_info = #{account} WHERE id = 1;")
    boolean updateAccount(int account);
}
