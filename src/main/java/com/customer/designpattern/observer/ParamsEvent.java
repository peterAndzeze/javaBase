package com.customer.designpattern.observer;

public class ParamsEvent<T> extends BusinessEvent {
    private String name;
    /**
     * 监测事件源
     */
    private ParamCheckService paramCheckService;

    public ParamsEvent(String name,ParamCheckService paramCheckService) {
        this.name=name;
        this.paramCheckService = paramCheckService;
    }

    @Override
    public T getResource() {
        return (T) paramCheckService;
    }
}
