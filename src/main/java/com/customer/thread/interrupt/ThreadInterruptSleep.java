package com.customer.thread.interrupt;

/**
 * @className: ThreadInterrupt
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/7
 **/
public class ThreadInterruptSleep {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
                /**
                 * sleep会把标志位给复位
                 * sleep不释放锁
                 */
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
