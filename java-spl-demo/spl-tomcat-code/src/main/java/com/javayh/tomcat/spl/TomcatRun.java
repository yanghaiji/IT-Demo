package com.javayh.tomcat.spl;

import com.javayh.app.spl.AppRun;

/**
 * <p>
 * 启动
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-05-07
 */
public class TomcatRun implements AppRun {
    public static final String APP = "app:tomcat://";

    @Override
    public void start() {
        System.out.println("tomcat 启动成功");
    }

    @Override
    public void stop() {
        System.out.println("tomcat 停止成功");
    }

    @Override
    public void destroy() {
        System.out.println("tomcat 销毁成功");
    }

    @Override
    public boolean isSupport(String name) {
        return name.startsWith(APP);
    }
}
