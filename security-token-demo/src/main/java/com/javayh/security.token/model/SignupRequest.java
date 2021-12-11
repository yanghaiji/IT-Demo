package com.javayh.security.token.model;

import lombok.Data;

import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-12-09
 */
@Data
public class SignupRequest {
    private String userName;
    private String password;
    private String email;
    private Set<String> role;
}
