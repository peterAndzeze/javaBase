package com.customer.designpattern.proxy.transaction;

/**
 * 事务测试
 */
public class TransactionClient {
    public static void main(String[] args) {
        ProxyFactory proxyFactory=new ProxyFactory();
        TransactionManager transactionManager=new TransactionManager();
        proxyFactory.setTransactionManager(transactionManager);
        //得到实例信息
        BusinessService businessService= (BusinessService) proxyFactory.getJdkProxy(new BusinessServiceImpl());
        businessService.insertUser();
    }
}
