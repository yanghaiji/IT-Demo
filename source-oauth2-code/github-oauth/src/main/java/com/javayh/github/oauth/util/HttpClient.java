package com.javayh.github.oauth.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javayh.github.oauth.dto.GithubAccessTokenBO;
import com.javayh.github.oauth.dto.GithubAccessTokenDTO;
import com.javayh.github.oauth.dto.GithubUserInfo;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * http 客户端
 * </p>
 *
 * @author Dylan-haiji
 * @version 1.0.0
 * @since 2020-05-15
 */
@Slf4j
@Order
@Configuration
public class HttpClient {


    /**
     * <p>
     * 初始化bean
     * </p>
     *
     * @param
     * @return okhttp3.OkHttpClient
     * @version 1.0.0
     * @author Dylan-haiji
     */
    @Bean
    public static OkHttpClient okHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //是否开启代理
        builder.connectTimeout(600, TimeUnit.SECONDS)
                .readTimeout(600, TimeUnit.SECONDS)
                .writeTimeout(600, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true).build();
        return builder.build();
    }

    /**
     * 获取用户access token
     * @param accessTokenDTO
     * @return
     * @throws JsonProcessingException
     */
    public static GithubAccessTokenBO getAccessToken(GithubAccessTokenDTO accessTokenDTO) throws JsonProcessingException {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        RequestBody body =
                RequestBody.create(mediaType, objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .header("Accept","application/json")
                .post(body)
                .build();
        try (Response response = okHttpClient().newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
            return objectMapper.readValue(string, GithubAccessTokenBO.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 获取github 用户信息
     * @param accessToken
     * @param type
     * @return
     */
    public static GithubUserInfo getUser(String accessToken,String type) {
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .addHeader("Authorization",type+" "+accessToken)
                .build();
        try {
            Response response = okHttpClient().newCall(request).execute();
            String string = response.body().string();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(string, GithubUserInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
