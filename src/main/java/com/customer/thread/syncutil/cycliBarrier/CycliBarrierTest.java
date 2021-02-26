package com.customer.thread.syncutil.cycliBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 协调多个线程同步执行操作的场合
 */
public class CycliBarrierTest {
    /**
     * 简介
     */
    public static void info(){
        /**
         * 构造函数里
         * 1。参与方数量，即参与线程数，该数值确定之后不能更改
         * 2。当所有线程被唤醒时，执行barrierCommand表示的Runnable。
         */
        /**
         * 源码方法 解释说明：
         * 1. CyclicBarrier是可以被重用的。以上一节的应聘场景为例，来了10个线程，这10个线程互相等
         * 待，到齐后一起被唤醒，各自执行接下来的逻辑；然后，这10个线程继续互相等待，到齐后再
         * 一起被唤醒。每一轮被称为一个Generation，就是一次同步点。
         * 2. CyclicBarrier 会响应中断。10 个线程没有到齐，如果有线程收到了中断信号，所有阻塞的线
         * 程也会被唤醒，就是上面的breakBarrier()方法。然后count被重置为初始值（parties），重
         * for (;;) { try {if (!timed) trip.await(); else if (nanos > 0L) nanos = trip.awaitNanos(nanos); } catch (InterruptedException ie) { if (g == generation && ! g.broken) { breakBarrier(); throw ie; } else { // We're about to finish waiting even if we had not // been interrupted, so this interrupt is deemed to // "belong" to subsequent execution. Thread.currentThread().interrupt(); } }if (g.broken) throw new BrokenBarrierException(); if (g != generation) return index; if (timed && nanos <= 0L) { breakBarrier(); throw new TimeoutException(); } } } finally { lock.unlock(); } }private void breakBarrier() { generation.broken = true; count = parties; trip.signalAll(); }private void nextGeneration() { // signal completion of last generation trip.signalAll(); // set up next generation count = parties; generation = new Generation(); } 4546474849505152535455565758596061626364656667686970717273747576777879808182838485868788899091
         * 新开始。
         * 3. 上面的回调方法，barrierAction只会被第10个线程执行1次（在唤醒其他9个线程之前），而
         * 不是10个线程每个都执行1次。
         */

    }

    /**
     * 示例场景
     * 使用场景：10个工程师一起来公司应聘，招聘方式分为笔试和面试。首先，要等人到齐后，开始笔
     * 试；笔试结束之后，再一起参加面试。把10个人看作10个线程，10个线程之间的同步过程如下图所示
     */

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(5);
        for (int i = 0; i <5 ; i++) {
           // new MyThread("面试者-"+(i+1),cyclicBarrier).start();
        }
        for (int i = 0; i <5 ; i++) {
            new MyNormalThread("面试者-"+(i+1)).start();
        }
    }
}
