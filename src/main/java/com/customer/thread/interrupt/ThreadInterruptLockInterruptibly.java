package com.customer.thread.interrupt;

import com.customer.thread.SleepHelper;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @className: ThreadInterruptLock
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/7
 **/
public class ThreadInterruptLockInterruptibly {
    private static ReentrantLock lock=new ReentrantLock();
    /**
    *能改变线程资源争抢的状态
    */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                SleepHelper.sleepSeconds(10);
            } finally {
                lock.unlock();
            }
            System.out.println("t1 end!");
        });

        t1.start();

        SleepHelper.sleepSeconds(1);


        Thread t2 = new Thread(() -> {
            System.out.println("t2 start!");
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("t2 end!");
        });

        t2.start();

        SleepHelper.sleepSeconds(1);

        t2.interrupt();

    }

}
