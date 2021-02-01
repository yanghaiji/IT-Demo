package com.javayh.nacos.config.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-01
 */
//@Configuration
public class AppConfig {
    @Autowired
    private NacosDomeConfig domeConfig;
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    /**
     * nacos动态更新是将所有信息更新到environment中，我们从environment取出，在赋值到现有环境的在进行refresh
     * 之后通过定时任务去刷新啥下文
     */
    @Scheduled
    public void refresh(){
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String app = environment.getProperty("spring.app03");
        domeConfig.setApp(app);
        applicationContext.refresh();
    }
}
