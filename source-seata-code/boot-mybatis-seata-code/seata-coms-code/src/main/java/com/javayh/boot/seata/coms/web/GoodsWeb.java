package com.javayh.boot.seata.coms.web;

import com.javayh.boot.seata.coms.service.GoodsService;
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

    @GetMapping(value = "goods/info/{account}")
    public String goods(@PathVariable int account){
        return  goodsService.updateAccount(account);
    }
}
