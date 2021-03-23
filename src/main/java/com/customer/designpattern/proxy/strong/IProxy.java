package com.customer.designpattern.proxy.strong;

/**
 * 增强代理类，如spring的transaction 就是利用动态代理实现的
 */
public interface IProxy {
    /**
     * 吃饭前/睡觉前刷牙
     */
    public void shuaya();

}


