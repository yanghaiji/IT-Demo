package com.javayh.boot.seata.coms.dao;

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

    @Update("UPDATE surplus_goods_info SET  account = #{account} WHERE id = 1;")
    boolean updateAccount(int account);
}
