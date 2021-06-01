package com.customer.designpattern.mediator;

/**
 * 同事类
 * @author wodezuiaishinageren
 */
public class ConcreteColleague2 extends Colleague {
    /**
     * 通过构造传递中介者
     * @param mediator
     */
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    /**
     * 同事类方法
     */
    public void selfMethod2() {
        System.out.println("self method "+this.getClass().getName());
    }

    /**
     * 处理依赖方法
     */
    public void depMethod2(){
        System.out.println("自身业务处理。。。");
        /**
         * 自己不能处理的业务逻辑，委托给中介者处理
         */
        super.mediator.doSomething2();

    }


}
