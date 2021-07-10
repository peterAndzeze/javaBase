package com.customer.thread.interrupt;

import com.customer.thread.lock.ReentrantLockInfo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @className: ThreadInterruptLock
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/7
 **/
public class ThreadInterruptLock {
    static ReentrantLock reentrantLock=new ReentrantLock();
    //并不能改变线程资源争抢的状态
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            reentrantLock.lock();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
            System.out.println("t is end");
        });
        t.start();
        Thread t1=new Thread(()->{
            reentrantLock.lock();
            try {
            }finally {
                reentrantLock.unlock();
            }
            System.out.println("t1 is end");
        });
        t1.start();

        t1.interrupt();
    }
}
