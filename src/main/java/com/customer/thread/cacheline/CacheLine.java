package com.customer.thread.cacheline;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @className: CacheLine
 * @description: 缓存行 的测试
 * @author: sw
 * @date: 2021/7/9
 **/
public class CacheLine {
    private static final long NUM=1_0000_0000L;

    public static class T{
        //private long a,b,c,d,e,f,g;
        public long x;
        //private long h,i,j,k,l,m,n;

    }
    //56153858
    //54343383
    static T [] arr=new T[2];
    static {
        arr[0]=new T();
        arr[1]=new T();
    }
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(2);
        Thread t1=new Thread(()->{
            for (long i = 0; i < NUM; i++) {
                arr[0].x=i;
            }
            countDownLatch.countDown();
        });

        Thread t2=new Thread(()->{
            for (long i = 0; i < NUM; i++) {
                arr[1].x=i;
            }
            countDownLatch.countDown();
        });
        long start=System.nanoTime();
        t1.start();
        t2.start();
        countDownLatch.await();
        System.out.println("end time ："+(System.nanoTime()-start)/100_0000);

    }



}
