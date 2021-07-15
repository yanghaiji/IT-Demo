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
public class GithubUserPlan {

    private String name;

    private int space;

    private int collaborators;

    private int private_repos;
}
