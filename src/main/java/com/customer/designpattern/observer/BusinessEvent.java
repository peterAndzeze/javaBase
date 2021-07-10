package com.customer.designpattern.observer;

/**
 * 业务事件
 */
public abstract class BusinessEvent<T> {
    /**
     * 获取事件源
     * @return
     */
    public  abstract T getResource();
}
