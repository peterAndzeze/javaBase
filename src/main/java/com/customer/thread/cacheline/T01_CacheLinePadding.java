package com.customer.thread.cacheline;

import java.util.concurrent.CountDownLatch;

/**
 * @className: T01_CacheLinePadding
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/9
 **/
public class T01_CacheLinePadding {
    public static long COUNT = 10_0000_0000L;

    private static class T {
       /* private long p1, p2, p3, p4, p5, p6, p7;
        private long p9, p10, p11, p12, p13, p14, p15;*/
       private int p1, p2, p3, p4, p5, p6, p7;
       public int x = 0;
        private int p9, p10, p11, p12, p13, p14, p15;

    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(8);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }

            latch.countDown();
        });
        Thread t6 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }

            latch.countDown();
        });
        Thread t7= new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }

            latch.countDown();
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }

            latch.countDown();
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }

            latch.countDown();
        });
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }

            latch.countDown();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }

            latch.countDown();
        });

        Thread t8 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }

            latch.countDown();
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        latch.await();
        System.out.println((System.nanoTime() - start) / 100_0000);
    }

}
