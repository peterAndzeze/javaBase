package com.customer.designpattern.proxy.msb.v1;

/**
 * @className: StaticProxyClient
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/3
 **/
public class StaticProxyClient {


    public static void main(String[] args) {
        new TimeProxy(new LogProxy(new Tank())).move();
    }
}
