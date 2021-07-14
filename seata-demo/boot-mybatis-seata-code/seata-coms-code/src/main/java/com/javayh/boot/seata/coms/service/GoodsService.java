package com.javayh.boot.seata.coms.service;

import com.javayh.boot.seata.coms.dao.GoodsDao;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-22
 */
@Slf4j
@Service
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;

    /**
     *
     * @param account
     */
    //@GlobalTransactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public String updateAccount(int account){
        log.info("开启全局事务 id 为 {}", RootContext.getXID());
        goodsDao.updateAccount(account);
        if(account == 5){
            //throw new RuntimeException("测试失败回滚");
            return "1";
        }
        return "0";
    }
}
