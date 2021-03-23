package com.customer.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;

public class DynamicClient {
    public static void main(String[] args) {
        //定义业务类
        Subject subject=new RealSubject();
        //定义handler
        InvocationHandler handler=new MyInvokeHandler(subject);
        Subject proxy=DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),handler);
        proxy.doSomething(" 我是被代理的业务函数逻辑");
    }
}
