package com.customer.designpattern.proxy.transaction;

public class BusinessServiceImpl implements BusinessService {
    @Override
    public void insertUser(){
            System.out.println("插入用户数据 事务开始执行");
            //int i=1/0;
    }
}
