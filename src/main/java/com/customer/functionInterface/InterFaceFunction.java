package com.customer.functionInterface;

/**
 * 函数式接口 在一个函数式接口中只能存在一个抽象方法 否则报错
 *
 * 每一个lambda表达式都对应一个类型，通常是接口类型。
 * 而“函数式接口”是指仅仅只包含一个抽象方法的接口，
 * 每一个该类型的lambda表达式都会被匹配到这个抽象方法。
 * 因为 默认方法 不算抽象方法，所以你也可以给你的函数式接口添加默认方法。
 * @FunctionalInterface 可以不添加
 */
@FunctionalInterface
public interface InterFaceFunction {
    /**
     * 抽象方法
     */
    public void method();
    /**
     *
     *默认方法
     */
    public default  void defaultMethod(){

        System.out.println("Default impl");
    }

}
