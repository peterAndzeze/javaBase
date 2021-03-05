package com.customer.thread.syncatomicinfo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 同步数据类型
 */
public class AtoMicInfo {

    private int count=0;

    /**
     * 变量++
     */
    public synchronized void  increment(){
        count++;
    }

    /**
     * 变量--
     */
    public synchronized void decrement(){
        count--;
    }

    /**
     * AtomicInteger的 getAndIncrement() 方法和 getAndDecrement() 方法都调用了一个方法：
     * U.getAndAddInt(…) 方法，该方法基于CAS实现：
     * do-while循环直到判断条件返回true为止。该操作称为自旋。
     * 调用了 compareAndSetInt 方法，该方法的实现：
     * 方法中，
     * 第一个参数表示要修改哪个对象的属性值；
     * 第二个参数是该对象属性在内存的偏移量；
     * 第三个参数表示期望值；
     * 第四个参数表示要设置为的目标值
     *
     */

    private AtomicInteger atomicCount=new AtomicInteger(0);
    public void add(){
        atomicCount.getAndIncrement();
    }

    public void minus(){
        atomicCount.getAndDecrement();
    }


}
