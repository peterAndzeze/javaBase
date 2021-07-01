package com.customer.designpattern.decorator;

/**
 * 佐料 装饰
 */
public class CondimentsDecorator extends PersonDecorator{

    public CondimentsDecorator(PersonSurvive personSurvive) {
        super(personSurvive);
    }

    @Override
    public void eat() {
        setCondiments(personSurvive);
        personSurvive.eat();
    }

    private void setCondiments(PersonSurvive personSurvive){
        System.out.println("放入佐料");
    }

}
