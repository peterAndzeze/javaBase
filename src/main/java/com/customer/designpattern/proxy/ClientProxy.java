package com.customer.designpattern.proxy;

import com.customer.designpattern.proxy.special.SpecialSubject;
import com.customer.designpattern.proxy.special.SpecialSubjectInterface;

/**
 * 代理模式测试类
 */
public class ClientProxy {
    public static void main(String[] args) {
        //未知代理类
        /*SpecialProxy specialProxy=new SpecialProxy("张三");
        specialProxy.eat();
        specialProxy.sleep();*/
        SpecialSubjectInterface specialSubject=new SpecialSubject("张三");
        SpecialSubjectInterface proxy = specialSubject.getProxy();
        System.out.println(proxy);
        System.out.println(specialSubject);
        System.out.println(proxy.getProxy());
        proxy.eat();
        proxy.sleep();

    }
}
