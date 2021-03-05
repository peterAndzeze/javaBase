package com.customer.thread.producerandconsumer;

public class PCThreadMain {
    /**
     * 为什么wait() 和notify  必须和synchronized 一起使用
     * 两个线程之间要通信，对于同一个对象来说，一个线程调用该对象的wait()，另一个线程调用该对象的notify()，该
     * 对象本身就需要同步！所以，在调用wait()、notify()之前，要先通过synchronized关键字同步给对象，
     * 也就是给该对象加锁。
     *
     */

    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue =new TaskQueue();
        new ProducerThread(taskQueue).start();
        new ConsumerThread(taskQueue).start();
        Thread.sleep(10000);
        // 进程结束
        System.exit(0);

    }
}
