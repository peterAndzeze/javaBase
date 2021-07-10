package com.customer.designpattern.observer;

/**
 * @className: ParamService
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/2
 **/
public class ParamService implements BusinessObserver {
    @Override
    public void doSomething(BusinessEvent businessEvent) {
        System.out.println("参数服务监测到参数事件异常");
        calError();
    }

    private void calError(){
        System.out.println("记录错误信息'");
    }


}
