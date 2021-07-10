package com.customer.designpattern.observer;

/**
 * @className: LogService
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/2
 **/
public class LogService implements BusinessObserver {
    @Override
    public void doSomething(BusinessEvent businessEvent) {
        System.out.println("日志监听");
    }


}
