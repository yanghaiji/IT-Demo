package com.javayh.nacos.discovery.web;

import com.javayh.nacos.discovery.config.NacosDome2Config;
import com.javayh.nacos.discovery.service.NacosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-01
 */
@RestController
public class DiscoveryController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.url}")
    private String appUrl;

    @Autowired(required = false)
    private NacosService nacosService;
    /**
     * 通过http 进行远程调用
     * @return
     */
    @GetMapping("/echo/app-name")
    public String echoAppName(){
        //使用 LoadBalanceClient 和 RestTemolate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-config-demo");
        String url = String.format("http://%s:%s/%s",serviceInstance.getHost(),serviceInstance.getPort(),appUrl);
        System.out.println("request url:"+url);
        return restTemplate.getForObject(url,String.class);
    }

    /**
     * 通过feign实现服务调用
     * @return
     */
    @GetMapping("/echo/app-config")
    public NacosDome2Config echoAppConfig(){
        return nacosService.getConfig();
    }

}
