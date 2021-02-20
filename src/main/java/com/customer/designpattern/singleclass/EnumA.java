package com.customer.designpattern.singleclass;

/**
 * 枚举类单例模式 推荐 线程安全
 */
public enum EnumA {
    a;
    public EnumA getInstances(){
        return a;
    }
}

/**
 *翻译代码如下：
 * public final class A extends Enum< A> {
 *      public static final A a;
 *      public static A[] values();
 *      public static AvalueOf(String s);
 *      static {};
 * }
 */