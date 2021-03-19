package com.customer.designpattern.builder.special;

/**
 * 构建者扩展
 */
public class ClientBuilderSpecial {
    public static void main(String[] args) {
        Director director=new Director();
        director.getABwModel().run();
        director.getCBenzModel().run();
    }
}
