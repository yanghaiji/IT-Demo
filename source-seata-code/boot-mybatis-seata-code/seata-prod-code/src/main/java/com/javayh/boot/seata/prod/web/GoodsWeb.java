package com.javayh.boot.seata.prod.web;

import com.javayh.boot.seata.prod.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-22
 */
@RestController
public class GoodsWeb {

    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = "goods/{account}")
    public void goods(@PathVariable int account){
        goodsService.updateAccount(account);
    }
}
