package com.customer.thread.interrupt;

import com.customer.thread.SleepHelper;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @className: ThreadInterruptLock
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/7
 **/
public class ThreadInterruptLockInterruptiblyV1 {
    private static ReentrantLock reentrantLock=new ReentrantLock();
    /**
    *能改变线程资源争抢的状态
    */
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            reentrantLock.lock();
            try {
                SleepHelper.sleepSeconds(10);
            } finally {
                reentrantLock.unlock();
            }
            System.out.println("t is end");
        });
        t.start();
        SleepHelper.sleepSeconds(1);

        Thread t1=new Thread(()->{
            System.out.println("t1 is start");
            try {
                reentrantLock.lock();

            }finally {
                reentrantLock.unlock();
            }
            System.out.println("t1 is end");
        });
        t1.start();
        SleepHelper.sleepSeconds(1);

        t1.interrupt();
    }
}
