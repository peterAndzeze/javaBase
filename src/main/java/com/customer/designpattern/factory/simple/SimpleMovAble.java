package com.customer.designpattern.factory.simple;

/**
 * 扩展性不是特别好
 */
public class SimpleMovAble {

    public Car getCar(){
        return new Car();
    }

    public Plane getPlane(){
        return new Plane();
    }
}
