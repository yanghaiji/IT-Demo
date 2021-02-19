package com.javayh.github.oauth.dto;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-02
 */
@Data
public class GithubAccessTokenBO {
    private String access_token;
    private String scope;
    private String token_type;
}
