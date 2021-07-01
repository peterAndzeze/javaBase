package com.customer.designpattern.mediatorandfacde;

/**
 * 中介者模式
 * 通用抽象中介者
 * @author wodezuiaishinageren
 */
public abstract class Mediator {
    /**
     *定义同事类
     * 在Mediator抽象类中我们只定义了同事类的注入，
     * 为什么使用同事实现类注入而不使用抽象类注入呢？
     * 那是因为同事类虽然有抽象，但是没有每个同事类必须要完成的业务方法，
     * 当然如果每个同事类都有相同的方法，比如execute、handler等，那当然注入抽象类，
     * 做到依赖倒置
     */
    protected ConcreteColleague1 c1;
    protected ConcreteColleague2 c2;

    /**
     * 通过get /set函数将同事类注入进来
     * @return
     */
    public ConcreteColleague1 getC1() {
        return c1;
    }

    public void setC1(ConcreteColleague1 c1) {
        this.c1 = c1;
    }

    public ConcreteColleague2 getC2() {
        return c2;
    }

    public void setC2(ConcreteColleague2 c2) {
        this.c2 = c2;
    }

    /**
     * 中介者模式业务逻辑
     */
    public  abstract void doSomething1();

    /**
     * 中介者模式业务逻辑
     */
    public abstract void doSomething2();


}
