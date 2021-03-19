package com.customer.designpattern.builder.normal;

/**
 * 创建宝马车实例
 */
public class BMWModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("宝马车启动了");
    }

    @Override
    protected void stop() {
        System.out.println("宝马车停止了");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马车鸣笛了");
    }
}
