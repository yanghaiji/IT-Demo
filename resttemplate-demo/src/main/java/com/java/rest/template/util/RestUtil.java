package com.java.rest.template.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Map;

/**
 * <p>
 * rest util
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-19
 */
@Configuration
public class RestUtil {

    private RestTemplate restTemplate;

    public RestUtil(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T post(String url, Map<String, String> headers, Map<String, String> params, Class<T> tClass) {
        return exchange(url, HttpMethod.POST, headers, params, tClass);
    }

    public <T> T get(String url, Map<String, String> headers, Map<String, String> params, Class<T> tClass) {
        return exchange(url, HttpMethod.GET, headers, params, tClass);
    }

    public <T> T exchange(String url, HttpMethod httpMethod, Map<String, String> headers, Map<String, String> params, Class<T> tClass) {
        //header信息，包括了http basic认证信息
        MultiValueMap<String, String> headersMap = new LinkedMultiValueMap<>();
        if (headers != null) {
            headersMap.setAll(headers);
        }
        //body请求体部分
        MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();
        if (params != null) {
            bodyMap.setAll(params);
        }
        //merge成为一个HttpEntity
        HttpEntity<MultiValueMap<String, String>> multiValueMapHttpEntity = new HttpEntity<>(bodyMap, headersMap);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, httpMethod, multiValueMapHttpEntity, tClass);
        return responseEntity.getBody();
    }

    /**
     * 上传文件到文件系统
     *
     * @param file
     * @return
     */
    public <T> T upload(File file, String uploadUrl, Class<T> tClass) {
        if (file != null && !file.exists()) {
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        //将文件传入文件管理系统
        FileSystemResource resource = new FileSystemResource(file);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("file", resource);
        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(param, headers);
        ResponseEntity<T> responseEntity = restTemplate.postForEntity(uploadUrl, files, tClass);
        //删除本地文件
        //file.delete();
        return responseEntity.getBody();
    }
}
