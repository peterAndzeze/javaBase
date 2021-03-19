package com.customer.designpattern.proxy.normal;

/**
 * 普通代理测试类
 */
public class NormalProxyClient {
    public static void main(String[] args) {
        NormalProxy normalProxy=new NormalProxy("张三");
        normalProxy.eat();
        normalProxy.sleep();
    }
}
