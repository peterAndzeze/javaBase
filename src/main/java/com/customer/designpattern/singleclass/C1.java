package com.customer.designpattern.singleclass;

/**
 * 静态内部类（推荐）
 *C2在C1装载的时候并不会装载，而是会在调用getInstance的时候装载，这利用了JVM的装载机制。这样
 * 一来，优点有两点，其一就是没有C2加载的时候，就装载了C1对象，而是在调用的时候才装载，避免了资
 * 源的浪费。其二是多线程状态下，没有线程安全性的问题。
 */
public class C1 {
    private C1(){

    }

    /**
     * 私有的静态内部类
     */
    private static class C2{
        private static C1 c1=new C1();
    }
    /**
     * 对外获取实例方法
     * @return
     */
    public  static C1 getInstance(){
        return C2.c1;
    }



}
