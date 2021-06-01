package com.customer.designpattern.command;

/**
 * 具体的接收者抽象类
 * @author wodezuiaishinageren
 */
public abstract class Receiver {
    /**
     * 抽象接收者 定义每个接收者都必须完成的业务
     */
    public abstract void doSomething();

}
