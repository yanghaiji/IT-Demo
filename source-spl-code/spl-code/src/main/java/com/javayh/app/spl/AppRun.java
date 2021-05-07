package com.javayh.app.spl;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-05-07
 */
public interface AppRun {

    /**
     * 启动
     */
    void start();

    /**
     * 停止
     */
    void stop();

    /**
     * 销毁
     */
    void destroy();

    /**
     * 是否支持协议
     * @param name 协议名
     * @return
     */
    boolean isSupport(String name);

}
