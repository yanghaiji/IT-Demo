package com.java.rest.template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * reset template 配置
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
@Configuration
public class ResetTemplateConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        // 自定义拦截
        List<ClientHttpRequestInterceptor> list = new ArrayList<>();
        list.add(new RestInterceptor());
        restTemplate.setInterceptors(list);
        // 自定义 response error
        restTemplate.setErrorHandler(new MyResponseErrorHandler());
        // 可以自定义 http message converter
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();

        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);
        factory.setConnectTimeout(15000);
        // 设置代理
        //factory.setProxy(null);
        return factory;
    }


}
