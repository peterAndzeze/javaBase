package com.customer.designpattern.nullproject;

/**
 * 定一个抽象类
 */
public abstract class AbstractCustomer {

    protected String name;

    /**
     * 是否为空
     * @return
     */
    public abstract  boolean isNill();

    /**
     * 返回名称
     * @return name
     */
    public abstract String getName();
}
