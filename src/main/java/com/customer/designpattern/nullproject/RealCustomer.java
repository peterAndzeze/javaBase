package com.customer.designpattern.nullproject;

/**
 * 定一个一个真实的类
 */
public class RealCustomer  extends AbstractCustomer {
    public RealCustomer(String name) {
        this.name=name;
    }

    @Override
    public boolean isNill() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
