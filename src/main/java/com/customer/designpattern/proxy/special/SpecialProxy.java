package com.customer.designpattern.proxy.special;

/**
 * 定义代理类
 */
public class SpecialProxy implements SpecialSubjectInterface {
    private SpecialSubjectInterface specialSubjectInterface;

    public SpecialProxy(SpecialSubjectInterface specialSubjectInterface) {
        this.specialSubjectInterface=specialSubjectInterface;
    }

    @Override
    public void eat() {
            this.specialSubjectInterface.eat();
    }

    @Override
    public void sleep() {
        this.specialSubjectInterface.sleep();
    }

    @Override
    public SpecialSubjectInterface getProxy() {
        //备注：代理也可以有代理
        return this;
    }
}
