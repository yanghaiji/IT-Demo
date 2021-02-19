package com.javayh.github.oauth.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javayh.github.oauth.dto.GithubAccessTokenBO;
import com.javayh.github.oauth.dto.GithubAccessTokenDTO;
import com.javayh.github.oauth.dto.GithubUserInfo;
import com.javayh.github.oauth.util.HttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *      参看:https://docs.github.com/en/developers/apps/creating-an-oauth-app
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-02
 */
@RestController
public class GithubAccessTokenController {

    /**
     * 获取用户基本信息
     * @param code 授权码
     * @param state 状态值
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping(value = "/access-token")
    public GithubUserInfo getToken(@RequestParam String code ,@RequestParam String state) throws JsonProcessingException {
        GithubAccessTokenDTO accessTokenDTO = new GithubAccessTokenDTO();
        accessTokenDTO.setClient_id("f8d4932d0589c31e4ae2");
        accessTokenDTO.setClient_secret("5c043645a4939dc5343739f63de672d508bf8642");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("https://blog.csdn.net/weixin_38937840/article/details/105382447");
        accessTokenDTO.setState(state);
        //access_token=c2971568150c882deff55cce5a265955ad8a0524&scope=user&token_type=bearer
        //获取accessToken
        GithubAccessTokenBO accessToken = HttpClient.getAccessToken(accessTokenDTO);
        //获取用户信息
        GithubUserInfo user = HttpClient.getUser(accessToken.getAccess_token(),accessToken.getToken_type());
        return user;
    }

}
