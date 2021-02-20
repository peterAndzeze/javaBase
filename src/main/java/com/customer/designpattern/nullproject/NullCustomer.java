package com.customer.designpattern.nullproject;

/**
 * 空对象设计
 */
public class NullCustomer extends AbstractCustomer {
    @Override
    public boolean isNill() {
        return true;
    }

    @Override
    public String getName() {
        return "sorry Not exits customer";
    }
}
