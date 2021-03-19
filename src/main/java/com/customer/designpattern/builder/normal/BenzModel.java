package com.customer.designpattern.builder.normal;

/**
 * 创建奔驰车实例
 */
public class BenzModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("奔驰车启动了");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰车停止了");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰车鸣笛了");
    }
}
