package com.customer.designpattern.singleclass;

/**
 * 饿汉式单例模式 （静态变量）
 * 1.线程安全 全局唯一
 * 2.在类加载完成后即完成对象实例化，避免线程同步问题
 * 缺点：当类用不到的时候 ，导致资源浪费
 */
public class A {
    /**
     * 私有构造
     */
    private A(){
    }

    /**
     * 私有静态变量
     */
    private final static A a=new A();

    /**
     * 对外提供公有方法
     * @return
     */
    public static A getInstance(){
        return a;
    }
}
