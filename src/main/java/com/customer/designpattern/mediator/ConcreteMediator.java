package com.customer.designpattern.mediator;

/**
 * 通用中介者，即通用函数实现
 * @author wodezuiaishinageren
 */
public class ConcreteMediator extends Mediator {
    /**
     * 中介者所具有的方法doSomething1和doSomething2都是比较复杂的业务逻辑，
     * 为同事类服务，其实现是依赖各个同事类来完成的。
     *
     */
    @Override
    public void doSomething1() {
        /**
         * 调用同事类的方法
         */
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }

    @Override
    public void doSomething2() {
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }
}
