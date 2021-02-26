package com.customer.thread.lock;

public class AtomicInfo {
    /**
     * 简介
     */
    public void baseInfo(){
        /**
         * AtomicInteger是⼀系列相同类的代表之⼀，常⻅的还有AtomicLong、AtomicLong等，
         * 他们的实现原理相同，区别在与运算对象类型的不同。
         * 我们知道，在多线程程序中，诸如++i
         * 或
         * i++等运算不具有原⼦性，是不安全的线程操作之⼀。通常我们会使⽤synchronized将该操作变成⼀个原
         * ⼦操作，但JVM为此类操作特意提供了⼀些同步类，使得使⽤更⽅便，且使程序运⾏效率变得更⾼。通
         * 过相关资料显示，通常AtomicInteger的性能是ReentantLock的好⼏倍
         */
    }

}
