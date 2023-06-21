package com.javayh.proxy.demo.factory;

import com.javayh.proxy.demo.template.StateTemplate;
import com.javayh.proxy.demo.template.StateTemplateImpl;

import java.lang.reflect.Proxy;

/**
 * <p>
 * dai
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 */
public class ProxyFactory {

    /**
     * 可以根据状态创建不同的代理对象
     *
     * @param type 状态
     */
    public static StateTemplate createProxy(String type) {
        return (StateTemplate) Proxy.newProxyInstance(StateTemplate.class.getClassLoader(),
                new Class[]{StateTemplate.class}, new DyProxy(new StateTemplateImpl()));
    }
}
