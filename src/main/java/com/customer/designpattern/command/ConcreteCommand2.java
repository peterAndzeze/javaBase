package com.customer.designpattern.command;

/**
 * 具体命令类
 * @author wodezuiaishinageren
 */
public class ConcreteCommand2 extends Command{
    /**
     * 对应哪个命令接收者
     */
    private Receiver receiver;

    /***
     * 构造函数传递接收者
     * @param receiver
     */
    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 实现命令
     */
    @Override
    public void execute() {
        /**
         * 接收者处理业务
         */
        this.receiver.doSomething();
    }
}
