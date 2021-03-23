package com.customer.designpattern.proxy.dynamic;

public class BeforeAdvice  implements IAdvice{


    @Override
    public void execute() {
        System.out.println("前置操作************");

    }
}
