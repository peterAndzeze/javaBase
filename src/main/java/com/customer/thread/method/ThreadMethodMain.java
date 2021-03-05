package com.customer.thread.method;

/**
 * 线程方法函数测试
 * @author sw
 */
public class ThreadMethodMain {
    /**
     * join()：暂停线程的执行，直到调用该方法的线程执行结束为止。可以使用该方法等待另一个
     * Thread对象结束 此处输出 是等待main 函数的线程结束
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread=new JoinThread();
        JoinThread2 joinThread2=new JoinThread2("线程2");
        joinThread.start();
        joinThread2.start();
        joinThread2.join();
        System.out.println("main thread  ----》 is over");

    }

}
