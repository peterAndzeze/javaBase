package com.customer.designpattern.command;

/**
 * 定义命令调度者
 * @author wodezuiaishinageren
 */
public class Invoker {
    private Command command;

    /**
     * 传递命令
     * @param command
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 执行命令
     */
    public void action(){
        this.command.execute();
    }
}
