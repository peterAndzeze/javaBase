package com.customer.designpattern.singleclass;

/**
 * 枚举类单例模式 推荐 线程安全/防止序列化
 */
public enum EnumA {
    INSTANCE;
    public EnumA getInstances(){
        return INSTANCE;
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