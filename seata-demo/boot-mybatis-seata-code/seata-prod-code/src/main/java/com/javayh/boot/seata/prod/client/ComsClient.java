package com.javayh.boot.seata.prod.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-23
 */
@Component
@FeignClient(value = "boot-seata-app-coms",fallback = ComsClientFallback.class)
public interface ComsClient {
    @GetMapping(value = "/goods/info/{account}")
    String goods(@PathVariable(value = "account") int account);
}
@Component
class ComsClientFallback implements ComsClient{

    @Override
    public String goods(int account) {
        return "fallback";
    }
}
