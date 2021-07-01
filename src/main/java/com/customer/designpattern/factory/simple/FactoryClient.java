package com.customer.designpattern.factory.simple;

import com.customer.designpattern.factory.simple.CarFactory;

/**
 * 工厂设计模式
 */
public class FactoryClient {
    public static void main(String[] args) {
        new CarFactory().getCar().go();
    }

}
