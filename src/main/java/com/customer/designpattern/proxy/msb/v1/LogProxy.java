package com.customer.designpattern.proxy.msb.v1;

/**
 * @className: LogProxy
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/3
 **/
public class LogProxy implements MoveAble {
    private MoveAble moveAble;

    public LogProxy(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    @Override
    public void move() {
        System.out.println("记录日志开始");
        moveAble.move();
        System.out.println("记录日志结束");
    }
}
