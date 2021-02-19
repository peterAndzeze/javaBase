package com.customer.thread.keywords;

/**
 * wait 和notify的使用
 * @author sw
 */
public class WaitNotifyClass   {
    private Object lock=new Object();
    /**
     * 当时函数等待回答
     * @throws InterruptedException
     */
    public  void say() throws InterruptedException {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "is saying");
            this.wait();
        }
    }

    /**
     * 当前对象回答完毕后 才能执行下一个问题
     */
    public  void answer(){
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " answer over");
            this.notify();
        }
    }
}
