package com.customer.designpattern.observer;

/**
 * 业务观察者
 */
public interface BusinessObserver {
    /**
     * 监测业务发生
     * @param businessEvent
     */
    void doSomething(BusinessEvent businessEvent);

}
