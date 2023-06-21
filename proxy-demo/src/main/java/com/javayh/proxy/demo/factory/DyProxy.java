package com.javayh.proxy.demo.factory;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author haiji
 */
public class DyProxy implements InvocationHandler {

    private Object targetObject;

    public DyProxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(targetObject, args);
    }

}