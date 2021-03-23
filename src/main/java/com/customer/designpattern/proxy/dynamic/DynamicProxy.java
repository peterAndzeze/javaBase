package com.customer.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理  动态代理类
 */
public class DynamicProxy<T> {
    public static <T> T newProxyInstance(ClassLoader classLoader,
                                         Class<?> [] interfaces,
                                         InvocationHandler h){
        //寻找join point 连接点，AOP框架使用元数据定义
        if(true){
            //执行前置通知操作
            (new BeforeAdvice()).execute();
        }
        /**
         * 执行目标，并返回结果
         */
        Object o = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (T) o;
    }
}
