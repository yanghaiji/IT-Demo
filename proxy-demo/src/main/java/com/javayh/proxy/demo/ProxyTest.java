package com.javayh.proxy.demo;


import com.javayh.proxy.demo.factory.ProxyFactory;
import com.javayh.proxy.demo.template.StateTemplate;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-06-21
 */
public class ProxyTest {
    public static void main(String[] args) {
        StateTemplate a = ProxyFactory.createProxy("A");
        System.out.println("StateTemplate 的最终类型 --- " + a.toString());
        a.run();
    }
}
