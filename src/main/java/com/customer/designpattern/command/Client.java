package com.customer.designpattern.command;

/**
 * 客户端调用处理
 * @author wodezuiaishinageren
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 创建调度者
         */
        Invoker invoker=new Invoker();
        /**
         * 创建接收命令者
         */
        Receiver receiver=new ConcreteReceiver1();
        /**
         * 告诉命令者 由哪个接收者执行
         */
        Command command=new ConcreteCommand1(receiver);
        /**
         * 告诉调度者 下达什么指令
         */
        invoker.setCommand(command);
        /**
         * 执行命令
         */
        invoker.action();
    }
}
