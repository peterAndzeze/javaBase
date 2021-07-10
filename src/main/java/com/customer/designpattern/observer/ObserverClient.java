package com.customer.designpattern.observer;

/**
 * 观察者客户端
 */
public class ObserverClient {

    public static void main(String[] args) {
        ParamCheckService paramCheckService=new ParamCheckService();
        paramCheckService.addObserver(new ParamService()).addObserver(new LogService());
        paramCheckService.checkParam(null);
    }


}
