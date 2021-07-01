package com.customer.designpattern.decorator;

/**
 * 生火
 */
public class FireDecorator extends PersonDecorator {

    public FireDecorator(PersonSurvive personSurvive) {
        super(personSurvive);
    }

    /**
     * 扩展吃饭函数
     */
    @Override
    public void eat() {
        fire(personSurvive);
        personSurvive.eat();
    }

    public void fire(PersonSurvive personSurvive){
        System.out.println("生火");
    }
}
