package com.customer.designpattern.decorator;

/**
 * 装饰者 测试
 */
public class DecoratorClient {
    public static void main(String[] args) {
        PersonSurvive personSurvive=new BeiJIngPerson();
        PersonDecorator personDecorator=new FireDecorator(personSurvive);
        personDecorator.eat();
    }
}
