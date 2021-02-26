package com.customer.thread.syncutil.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;

public class PhaserCycliBarrierTest {
   private static final Phaser phaser=new Phaser(10);
    private static final Random random=new Random();
    public static void info(){
        /**
         * 从JDK7开始，新增了一个同步工具类Phaser，其功能比CyclicBarrier和CountDownLatch更加强
         * 大。可以代替CycliBarrier 和CountDownLatch
         *
         */
    }

    public static void main(String[] args) {

        for (int i = 0; i <10 ; i++) {
            new Thread("面试者-"+i){
                @Override
                public void run() {
                    System.out.println(getName()+"-开始去公司");
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"-已经到达公司");

                    /**
                     * 到达同步点，等待其他线程
                     */
                    phaser.arriveAndAwaitAdvance();
                    System.out.println(getName()+"-开始笔试");
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"-笔试结束");
                    /**
                     *  到达同步点，等待其他线程
                     */
                    phaser.arriveAndAwaitAdvance();
                    System.out.println(getName()+"-开始面试");
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"-面试结束");
                }
            }.start();
        }
    }


   /* public  void slowly(Thread thread){
        try {
            thread.get.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/







}
