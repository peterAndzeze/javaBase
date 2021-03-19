package com.customer.designpattern.proxy.normal;

/**
 * 某一个主题类
 */
public class NormalSubjet implements SubjectInterface {
    private String name;

    public NormalSubjet(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(this.name+" 在吃东西");
    }

    @Override
    public void sleep() {
        System.out.println(this.name+" 在睡觉");
    }
}
