package com.customer.designpattern.proxy.normal;

/**
 * 普通的代理类
 */
public class NormalProxy implements SubjectInterface {
    /**
     * 被代理对象
     */
    private SubjectInterface subjectInterface;

    /**
     * 给一个构造函数
     * @param name
     */
    public NormalProxy(String name) {
        this.subjectInterface = new NormalSubjet(name);
    }

    @Override
    public void eat() {
        this.subjectInterface.eat();
    }

    @Override
    public void sleep() {
        this.subjectInterface.sleep();
    }
}
