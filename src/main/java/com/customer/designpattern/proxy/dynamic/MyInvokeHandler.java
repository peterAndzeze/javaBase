package com.customer.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理 动态代理类
 */
public class MyInvokeHandler implements InvocationHandler {
    private Object target;

    public MyInvokeHandler(Object target) {
        this.target = target;
    }

    /**
     * 动态代理执行函数
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target,args);
    }
}
