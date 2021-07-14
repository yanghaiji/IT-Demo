package com.javayh.boot.seata.prod.service;

import com.javayh.boot.seata.prod.client.ComsClient;
import com.javayh.boot.seata.prod.dao.GoodsDao;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ComsClient comsClient;

    @Resource
    private GoodsDao goodsDao;

    /**
     *
     * @param account
     */
    @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional(rollbackFor = Exception.class)
    public void updateAccount(int account){
        log.info("开启全局事务 id 为 {}", RootContext.getXID());
        goodsDao.updateAccount(account);
        //远程调用
        String goods = comsClient.goods(account);
        if("fallback".equalsIgnoreCase(goods)){
            throw new RuntimeException("服务调用异常");
        }
        if (10 == account){
            throw new RuntimeException("人为制造异常");
        }

    }

}
