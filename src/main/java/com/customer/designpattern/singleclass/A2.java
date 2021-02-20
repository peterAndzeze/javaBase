package com.customer.designpattern.singleclass;


import java.io.Serializable;

/**
 * 饿汉式单例模式 （静态代码块） 序列化测试
 * 1.线程安全 全局唯一
 * 2.在类加载完成后触发静态代码块，完成对象实例化，避免线程同步问题
 * 缺点：当类用不到的时候 ，导致资源浪费
 * @author wodezuiaishinageren
 */
public class A2  implements Serializable {
    /**
     * 私有构造函数
     */
    private A2(){

    }

    /**
     * 私有静态变量
     */
    private final static A2 a;

    /**
     * 静态代码块初始化
     */
    static {
        a=new A2();
    }

    /**
     * 对外公共方法
     * @return
     */
    public static A2 getInstance(){
        return a;
    }

}
