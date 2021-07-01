package com.customer.designpattern.factory.abstractfactory;

import com.customer.designpattern.factory.abstractfactory.factory.ModernFactory;

/**
 * 在设计模式时
 *
 *
 * 形容词（可以干什么 干什么） 用接口
 * 名词 用抽象类
 */
public class AbstractFactoryClient {
    public static void main(String[] args) {
        AbstractFactory abstractFactory=new ModernFactory();
        abstractFactory.createFood().printName();
    }
}
