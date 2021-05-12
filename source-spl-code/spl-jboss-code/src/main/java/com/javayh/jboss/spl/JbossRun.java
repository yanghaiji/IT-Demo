package com.javayh.jboss.spl;

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
public class JbossRun implements AppRun {

    public static final String APP = "app:jboss://";

    @Override
    public void start() {
        System.out.println("jboss 启动成功");
    }

    @Override
    public void stop() {
        System.out.println("jboss 停止成功");
    }

    @Override
    public void destroy() {
        System.out.println("jboss 销毁成功");
    }

    @Override
    public boolean isSupport(String name) {
        return name.startsWith(APP);
    }
}
