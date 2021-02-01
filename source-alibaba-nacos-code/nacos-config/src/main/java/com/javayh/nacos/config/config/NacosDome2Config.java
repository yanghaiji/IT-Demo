package com.javayh.nacos.config.config;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosProperty;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  测试 nacos全局更新
 *  todo
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-01
 */
@Component
@NacosConfigurationProperties(
        dataId = "ext-config-common03.yaml",
        groupId = "REFRESH_GROUP",
        prefix = "spring",
        autoRefreshed = true)
public class NacosDome2Config {

    @NacosValue(value = "${app03}",autoRefreshed = true)
    private String app;
    @NacosValue(value = "${status}",autoRefreshed = true)
    private Boolean status;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app =app;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
