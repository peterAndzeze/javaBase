package com.customer.designpattern.proxy.strong;

/**
 * 增强代理类测试客户端
 */
public class StrongProxyClient {

    public static void main(String[] args) {
        StrongBusiness strongBusiness=new StrongBusinessImpl("张三");
        StrongProxy strongProxy=new StrongProxy(strongBusiness);
        strongProxy.eat();
        strongProxy.sleep();
    }
}
