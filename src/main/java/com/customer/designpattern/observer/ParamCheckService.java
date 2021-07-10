package com.customer.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tom
 * 业务服务 被观察者
 */
public class ParamCheckService {

    private String params;
    private List<BusinessObserver> businessObservers=new ArrayList<>();

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 添加观察者
     * @param businessObserver
     * @return
     */
    public ParamCheckService addObserver(BusinessObserver businessObserver){
        businessObservers.add(businessObserver);
        return this;
    }


    /**
     *
     * @return
     */
    public boolean checkParam(String params){
        if(null==params) {

            BusinessEvent businessEvent=new ParamsEvent("参数验证事件",this);
            for(BusinessObserver businessObserver:businessObservers){
                businessObserver.doSomething(businessEvent);
            }
            return false;
        }
        return true;
    }

}
