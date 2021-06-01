package com.customer.designpattern.command.perfect;

import com.customer.designpattern.command.Receiver;

/**
 *
 * @author wodezuiaishinageren
 */
public abstract class Command {
    protected final Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver=receiver;
    }

    /**
     *每个命令的执行方法
     */
    public abstract void execute();
}
