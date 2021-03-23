package com.customer.designpattern.proxy.strong;

public class StrongProxy implements IProxy ,StrongBusiness {
    private StrongBusiness strongBusiness;

    public StrongProxy(StrongBusiness strongBusiness) {
        this.strongBusiness = strongBusiness;
    }

    @Override
    public void shuaya() {
        System.out.println("先刷牙");
    }

    @Override
    public void eat() {
        this.shuaya();
        this.strongBusiness.eat();
    }

    @Override
    public void sleep() {
        this.shuaya();
        this.strongBusiness.sleep();
    }
}
