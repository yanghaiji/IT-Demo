package com.javayh.github.oauth.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-02
 */
@Controller
public class GithubAuthController {


    /**
     * 进入授权页面 点击GitHub 授权
     * @return
     */
    @GetMapping(value = "login")
    public String login(){
        return "login.html";
    }


}
