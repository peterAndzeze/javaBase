package com.customer.designpattern.proxy.strong;

/**
 *
 */
public class StrongBusinessImpl implements StrongBusiness {
    private String name;

    public StrongBusinessImpl(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(this.name+"开始吃饭");
    }

    @Override
    public void sleep() {
        System.out.println(this.name+"睡觉吃饭");

    }
}
