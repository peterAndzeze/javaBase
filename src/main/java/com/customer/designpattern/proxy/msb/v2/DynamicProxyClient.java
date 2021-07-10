package com.customer.designpattern.proxy.msb.v2;

import java.lang.reflect.Proxy;

/**
 * @className: DynamicProxyClient
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/5
 **/
public class DynamicProxyClient {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Tank tank=new Tank();

        MoveAble moveAble = (MoveAble)Proxy.newProxyInstance(tank.getClass().getClassLoader(), new Class[]{MoveAble.class}, new TimeProxy(tank));
        moveAble.move();
        moveAble.shut();
    }
}
