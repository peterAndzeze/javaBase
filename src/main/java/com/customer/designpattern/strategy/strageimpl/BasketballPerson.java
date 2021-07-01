package com.customer.designpattern.strategy.strageimpl;

/**
 * 篮球运动员
 */
public class BasketballPerson{
    int age;

    public BasketballPerson(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BasketballPerson{" +
                "age=" + age +
                '}';
    }
}
