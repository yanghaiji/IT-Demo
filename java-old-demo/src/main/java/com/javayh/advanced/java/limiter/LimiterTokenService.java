package com.javayh.advanced.java.limiter;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2020-12-03 5:22 PM
 */
public interface LimiterTokenService {

    /**
     * <p>
     * 创建token
     * </p>
     *
     * @param
     * @return java.lang.String
     * @version 1.0.0
     * @since 12/3/2020
     */
    String createLimiterToken();

    /**
     * <p>
     * 校验token的合法性
     * </p>
     *
     * @param token value
     * @param time  设置过期时间
     * @return boolean
     * @version 1.0.0
     * @since 12/3/2020
     */
    boolean checkToken(String token, Long time);

    /**
     * 设置过期时间
     *
     * @param token
     */
    void addTokenTime(String token);
}
