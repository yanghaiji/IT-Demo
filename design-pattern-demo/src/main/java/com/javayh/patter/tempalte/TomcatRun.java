package com.javayh.patter.tempalte;

/**
 * <p>
 *      实现模板方法
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-25
 */
public class TomcatRun extends TomcatTemplate{
    @Override
    void port(int port) {
        System.out.println("Tomcat port is "+port);
    }

    @Override
    void connectionTimeout(Integer time) {
        System.out.println("Tomcat connectionTimeout is "+time);
    }

    @Override
    void contextPath(String path) {
        System.out.println("Tomcat contextPath is "+path);
    }
}
