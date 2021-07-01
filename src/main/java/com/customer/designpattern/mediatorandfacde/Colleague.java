package com.customer.designpattern.mediatorandfacde;

/**
 * 通用抽象同事类
 * @author wodezuiaishinageren
 */
public abstract class Colleague {
    /**
     * 注入中介者
     * 这个基类也非常简单。一般来说，中介者模式中的抽象都比较简单，
     * 是为了建立这个中介而服务的
     * 为什么同事类要使用构造函数注入中介者，而中介者使用getter/setter方式注入同事类呢？
     * 这是因为同事类必须有中介者，而中介者却可以只有部分同事类
     *
     */
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
