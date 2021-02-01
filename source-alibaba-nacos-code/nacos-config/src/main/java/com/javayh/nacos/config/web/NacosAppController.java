package com.javayh.nacos.config.web;

import com.javayh.nacos.config.config.NacosDomeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试nacos动态配置
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-01
 */
@RefreshScope
@RestController
public class NacosAppController {

    @Value("${spring.app01}")
    private String app01;

    @Value("${spring.app02}")
    private String app02;

    //@NacosValue(value = "${spring.app03}", autoRefreshed = true)
    @Value(value = "${spring.app03}")
    private String app03;

    @Autowired
    private NacosDomeConfig dto;


    /**
     * Data Id 在默认的组 nacos-demo,不支持配置的动态刷新
     * @return
     */
    @GetMapping(value = "extension-default")
    public String extensionConfigs(){
        return app01;
    }

    /**
     * Data Id 不在默认的组，不支持动态刷新
     * @return
     */
    @GetMapping(value = "extension-group")
    public String extensionGroup(){
        return app02;
    }

    /**
     * Data Id 既不在默认的组，也支持动态刷新
     * @return
     */
    @GetMapping(value = "extension-refresh")
    public String extensionRefresh(){
        return app03;
    }

    @GetMapping(value = "get")
    public NacosDomeConfig get(){
        return dto;
    }
}
