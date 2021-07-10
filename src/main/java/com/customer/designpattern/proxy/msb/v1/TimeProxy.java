package com.customer.designpattern.proxy.msb.v1;

/**
 * @className: TimeProxy
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/3
 **/
public class TimeProxy implements MoveAble {
    private MoveAble moveAble;

    public TimeProxy(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    @Override
    public void move() {
        System.out.println("记录时间开始");
        moveAble.move();
        System.out.println("记录时间结束");
    }
}
