package com.javayh.testng.demo.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.springframework.http.HttpMethod.GET;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.testng.demo.httpclient → ApiTest
 * @since 2022-01-11
 */
@Slf4j
public class ApiTest {



    @BeforeSuite
    public void beforeSuite() {

        log.info("BeforeSuite ......");
    }


    @Test(testName = "http get",description = "http get")
    public void test01() {
        RestTemplate template = new RestTemplate();
        HttpEntity<MultiValueMap<String, String>> multiValueMapHttpEntity = new HttpEntity<>(null, null);
        ResponseEntity sync =  template.exchange("https://www.baidu.com", GET,multiValueMapHttpEntity,String.class);
        log.debug("首页 "+sync.getBody());
        Assert.assertNotNull(sync);
    }
}
