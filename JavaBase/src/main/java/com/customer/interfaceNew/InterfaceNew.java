package com.customer.interfaceNew;

/**
 * jdk 1.8中 只有abstract类型的方法 1.8及以上版本可以使用非abstract 方法
 * 用default 关键字修饰 实现类可以重写 也可以直接使用
 *
 */
public interface InterfaceNew {
    /**
     * 原始老的方法
     * @param word
     */
    public void say(String word);

    /**
     * 新方法
     * @param food
     */
    public default void eat(String food){
        System.out.println("baby is eating:"+food);
    }
}
