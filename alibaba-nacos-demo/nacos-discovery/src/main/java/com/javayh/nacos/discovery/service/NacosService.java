package com.javayh.nacos.discovery.service;

import com.javayh.nacos.discovery.config.NacosDome2Config;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-01
 */
@Component
@FeignClient(name = "nacos-config-demo",fallbackFactory = NacosDemoFallbackFactory.class)
public interface NacosService {
    @GetMapping(value = "getConfig")
    NacosDome2Config getConfig();
}

class NacosDemoFallbackFactory implements NacosService{

    @Override
    public NacosDome2Config getConfig() {
        return null;
    }
}
