package com.customer.designpattern.proxy.transaction;

/**
 * 模拟事物管理器
 */
public class TransactionManager {


    /**
     * 事务开始
     */
    public void beginTransaction(){
        System.out.println("DB 事务开始前");
    }

    /**
     * 提交
     */
    public void commitTransaction(){
        System.out.println("DB 提交事务");
    }

    /**
     * 回滚
     */
    public void rollbackTransaction(){
        System.out.println("DB 事务回滚");
    }
}
