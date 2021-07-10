package com.customer.designpattern.proxy.msb.v1;

/**
 * @className: Tank
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/3
 **/
public class Tank implements MoveAble {
    @Override
    public void move() {
        System.out.println(this.getClass().getName()+"is  move");
    }
}
