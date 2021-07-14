package com.javayh.mybatis.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@org.springframework.context.annotation.Configuration
public class MapperConfig {

    //注册插件
    @Bean
    public ExamplePlugin myPlugin() {
        ExamplePlugin myPlugin = new ExamplePlugin();
        //设置参数，比如阈值等，可以在配置文件中配置，这里直接写死便于测试
        Properties properties = new Properties();
        //这里设置慢查询阈值为1毫秒，便于测试
        properties.setProperty("time", "1");
        myPlugin.setProperties(properties);
        return myPlugin;
    }


    //将插件加入到mybatis插件拦截链中
    /*@Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            //插件拦截链采用了责任链模式，执行顺序和加入连接链的顺序有关
            ExamplePlugin myPlugin = new ExamplePlugin();
            //设置参数，比如阈值等，可以在配置文件中配置，这里直接写死便于测试
            Properties properties = new Properties();
            //这里设置慢查询阈值为1毫秒，便于测试
            properties.setProperty("time", "1");
            myPlugin.setProperties(properties);
            configuration.addInterceptor(myPlugin);
        };
    }*/
}
