package com.customer.designpattern.proxy.special;

/**
 * 特殊代理主题类
 */
public interface SpecialSubjectInterface {
    /**
     * 吃东西
     */
    public void eat();

    /**
     * 睡觉
     */
    public void sleep();

    /**
     * 获取具体主题可以执行的代理类
     * @return
     */
    public SpecialSubjectInterface getProxy();

}
