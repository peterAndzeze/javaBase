package com.customer.designpattern.singleclass;


/**
 * 饿汉式单例模式 （静态代码块）
 * 1.线程安全 全局唯一
 * 2.在类加载完成后触发静态代码块，完成对象实例化，避免线程同步问题
 * 缺点：当类用不到的时候 ，导致资源浪费
 */
public class A1 {
    /**
     * 私有构造函数
     */
    private A1(){

    }

    /**
     * 私有静态变量
     */
    private final static A1 a;

    /**
     * 静态代码块初始化
     */
    static {
        a=new A1();
    }

    /**
     * 对外公共方法
     * @return
     */
    public static A1 getInstance(){
        return a;
    }

}
