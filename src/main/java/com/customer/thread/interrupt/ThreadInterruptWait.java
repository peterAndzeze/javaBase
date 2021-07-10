package com.customer.thread.interrupt;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @className: ThreadInterrupt
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/7
 **/
public class ThreadInterruptWait {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {

            try {
                Thread.currentThread().wait(1000);
            } catch (InterruptedException e) {
                System.out.println("thread is interrupted");
                System.out.println(Thread.currentThread().isInterrupted());
            }


        });
        t.start();
        t.interrupt();
        //静态函数，这里写 获取到的是main 函数户的线程
        //t.interrupted();

    }


}
