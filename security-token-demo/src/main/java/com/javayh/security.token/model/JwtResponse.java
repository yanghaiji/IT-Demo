package com.javayh.security.token.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private String accessToken;
    private Long id;
    private String username;
    private String email;
    private List<String> roles;
    private String tokenType;

    public JwtResponse(String jwt, Long id, String username, String email, List<String> roles) {
        this.accessToken = jwt;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.tokenType = "Bearer";
    }
}
