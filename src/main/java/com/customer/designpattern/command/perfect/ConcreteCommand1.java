package com.customer.designpattern.command.perfect;

import com.customer.designpattern.command.ConcreteReceiver1;
import com.customer.designpattern.command.Receiver;

public class ConcreteCommand1 extends Command {
    public ConcreteCommand1() {
        super(new ConcreteReceiver1());
    }

    protected ConcreteCommand1(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        super.receiver.doSomething();
    }
}
