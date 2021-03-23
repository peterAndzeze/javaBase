package com.customer.designpattern.proxy.dynamic;

/**
 * 动态代理 业务实现类
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething(String str) {
        System.out.println("do something  --->"+str);
    }
}
