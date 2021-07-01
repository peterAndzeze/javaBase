package com.customer.designpattern.decorator;

/**
 * 北京人
 */
public class BeiJIngPerson implements PersonSurvive {
    @Override
    public void eat() {
        System.out.println("北京人吃饭");
    }
}
