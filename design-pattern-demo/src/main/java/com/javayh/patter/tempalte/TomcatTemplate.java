package com.javayh.patter.tempalte;

/**
 * <p>
 * 模拟tomcat启动
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-25
 */
public abstract class TomcatTemplate {

    /**
     * 设置端口
     * @param port
     */
    abstract void port(int port);

    /**
     * 设置超时时间
     * @param time
     */
    abstract void  connectionTimeout(Integer time);

    /**
     * 设置访问路径
     * @param path
     */
    abstract void  contextPath(String path);

    //...........

    public void run(int port,Integer time,String path){
        port(port);
        connectionTimeout(time);
        contextPath(path);
        System.out.println("Tomcat Run");
    }
}
