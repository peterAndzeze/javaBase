package com.customer.designpattern.proxy.msb.v2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @className: DynamicProxy
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/3
 **/
public class TimeProxy implements InvocationHandler {
    private MoveAble moveAble;

    public TimeProxy(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    public void before(){
        System.out.println("before  do something  ");
    }

    public void after(){
        System.out.println("after  do something  ");
    }

    /**
     *
     * @param proxy 生成的代理对象 就是  moveAble   MoveAble moveAble = (MoveAble)Proxy.newProxyInstance(tank.getClass().getClassLoader(), new Class[]{MoveAble.class}, new TimeProxy(tank));
     * @param method 是move方法
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy is  "+proxy.getClass().getSimpleName());
        before();
        Object invoke = method.invoke(moveAble, args);
        //System.out.println(invoke.toString());
        after();
        return invoke;
    }
}
