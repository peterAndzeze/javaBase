package com.customer.thread.syncutil.contdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 测试
 * 一个主线程要等待5个 Worker 线程执行完才能退出，可以使用CountDownLatch来实现：
 * 线程：
 */
public class CountDownLatchTest {
    /**
     * 简介
     */
    public static void info(){
        /**
         * CountDownLatch原理和Semaphore原理类似，同样
         * 是基于AQS，不过没有公平和非公平之分
         */

        /***
         * countDown()调用的AQS的模板方法releaseShared()，里面的tryReleaseShared(...)由
         * CountDownLatch.Sync实现。从上面的代码可以看出，只有state=0，tryReleaseShared(...)才会返回
         * true，然后执行doReleaseShared(...)，一次性唤醒队列中所有阻塞的线程。
         * 总结：由于是基于AQS阻塞队列来实现的，所以可以让多个线程都阻塞在state=0条件上，通过
         * countDown()一直减state，减到0后一次性唤醒所有线程。如下图所示，假设初始总数为M，N个线程
         * await()，M个线程countDown()，减到0之后，N个线程被唤醒。
         */
    }
    public static void main(String[] args) {
        /**
         * 初始化5个工作线程
         */
        CountDownLatch latch=new CountDownLatch(30);
        new MyThread("线程1", latch).start();
        new MyThread("线程2", latch).start();
        new MyThread("线程3", latch).start();
        new MyThread("线程4", latch).start();
        new MyThread("线程5", latch).start();
        // 当前线程等待
        try {
            latch.await();
            /**
             * 源码方法如下await()
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("程序运行结束");
    }
    /*public void await() throws InterruptedException {
            // AQS的模板方法
         sync.acquireSharedInterruptibly(1);
    }
    public final void acquireSharedInterruptibly(int arg) throws InterruptedException {
        if (Thread.interrupted()) throw new InterruptedException();
        // 被CountDownLatch.Sync实现
        if (tryAcquireShared(arg) < 0) doAcquireSharedInterruptibly(arg);
        }
        protected int tryAcquireShared(int acquires) {
            return (getState() == 0) ? 1 : -1;
        }
    }*/

}
