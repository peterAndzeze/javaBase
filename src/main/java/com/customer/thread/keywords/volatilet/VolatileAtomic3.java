package com.customer.thread.keywords.volatilet;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  保证原子性
 */
public class VolatileAtomic3 {
    /***
     * volatile 不保证原子性
     * 原子性定义：数据的一致性 完整性
     */
    private volatile int number=0;

    /**
     * 第二种方式 增加lock锁
     */
    Lock lock=new ReentrantLock();
    public  void addPlus(){
        lock.lock();
        try {
            number++;
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        VolatileAtomic3 volatileTest=new VolatileAtomic3();
        synchronizedMethod(volatileTest);
        /**
         * 默认后台两个线程 一个main 一个GC
         */
        while (Thread.activeCount()>2){
            /**
             * 等待其他线程执行完毕 在执行main 和GC线程
             */
            Thread.yield();
        }
        // 如果volatile保证原子性的话，最终的结果应该是20000
        // 执行多次后每次程序执行结果不一定是20000
        System.out.println(Thread.currentThread().getName()+"\t result: "+volatileTest.number);
    }

    public static void synchronizedMethod(VolatileAtomic3 volatileTest){
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    volatileTest.addPlus();
                }
            },String.valueOf(i)).start();
        }

    }


}
