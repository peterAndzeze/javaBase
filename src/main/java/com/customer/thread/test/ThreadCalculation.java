package com.customer.thread.test;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @className: ThreadCalculation
 * @description: 线程计算分析
 * @author: sw
 * @date: 2021/7/6
 **/
public class ThreadCalculation {
        private static double[] nums= new double[1_0000_0000];
        private static Random random=new Random();
        static DecimalFormat df=new DecimalFormat("0.00");
        static {
            for (int i = 0; i < nums.length; i++) {
                nums[i]=random.nextDouble();
            }
        }

        public static void t1(){
            long start=System.currentTimeMillis();
            int length = nums.length;
            double sum=0.0;
            for (int i = 0; i < length; i++) {
                sum+=nums[i];
            }
            System.out.println((System.currentTimeMillis()-start)+":"+df.format(sum));
        }
     static double d1=0.00;
        static double d2=0.00;
    public static void t2() throws InterruptedException {


        int segment =nums.length/2;

        Thread thread = new Thread(()->{
            for (int i = 0; i < segment; i++) {
               d1+=nums[i];
            }
        }
        );


        Thread thread2 = new Thread(() -> {
            for (int i = segment; i < nums.length; i++) {
                d2+=nums[i];
            }
        });
        long start=System.currentTimeMillis();

        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println((System.currentTimeMillis()-start)+":"+df.format(d1+d2));

    }

    private static void t3() throws InterruptedException {
        final int threadNum=14;
        Thread [] threads=new Thread[threadNum];
        //数据存放的段
        double [] result=new double[threadNum];
        final int segment=nums.length/threadNum;
        CountDownLatch downLatch=new CountDownLatch(threadNum);
        for (int i = 0; i <threadNum ; i++) {
            int m=i;
            threads[i]=new Thread(()->{
                for (int j = m*segment; j <(m+1)*segment && j<nums.length ; j++) {
                    result[m]+=nums[j];
                }
                downLatch.countDown();
            });
        }
        long start=System.currentTimeMillis();

        for (int i = 0; i <threadNum ; i++) {
            threads[i].start();
        }
        downLatch.await();
        Double sum=0.00;
        for (int i = 0; i <result.length ; i++) {
            sum+=result[i];
        }

        System.out.println((System.currentTimeMillis()-start)+":"+df.format(sum));
    }



    public static void main(String[] args) throws InterruptedException {
        t1();
        t2();
       t3();


    }

}
