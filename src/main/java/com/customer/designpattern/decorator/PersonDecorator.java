package com.customer.designpattern.decorator;

/**
 * 人类装饰器
 */
public abstract class PersonDecorator implements PersonSurvive {

    protected PersonSurvive personSurvive;

    public PersonDecorator(PersonSurvive personSurvive) {
        this.personSurvive = personSurvive;
    }

    /**
     * 实现吃饭接口
     */
    @Override
    public void eat() {
        personSurvive.eat();
    }
}
