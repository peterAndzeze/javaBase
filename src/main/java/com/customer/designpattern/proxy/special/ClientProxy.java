package com.customer.designpattern.proxy.special;

/**
 * 代理模式测试类
 */
public class ClientProxy {
    public static void main(String[] args) {
        //未知代理类
        SpecialProxy specialProxy=new SpecialProxy(new SpecialSubject("张三"));
        specialProxy.eat();
        specialProxy.sleep();
        //指定代理
       /* SpecialSubjectInterface specialSubject=new SpecialSubject("张三");
        SpecialSubjectInterface proxy = specialSubject.getProxy();

        proxy.eat();
        proxy.sleep();*/

    }
}
