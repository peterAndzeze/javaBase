package com.customer.designpattern.factory.simple;

/**
 * 汽车
 */
public class Car implements MoveAble {
    @Override
    public void go(){
        System.out.println("bmw go *******");
    }

}
