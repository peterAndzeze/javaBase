package com.customer.thread.syncutil.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;

public class PhaserCountDownLathTest {
    public static void info(){
        /**
         * 从JDK7开始，新增了一个同步工具类Phaser，其功能比CyclicBarrier和CountDownLatch更加强
         * 大。可以代替CycliBarrier 和CountDownLatch
         *
         */
    }

    public static void main(String[] args) {
        Phaser phaser=new Phaser(5);
        for (int i = 0; i <5 ; i++) {
            new Thread("CountDownLatch线程-"+(i)){
                private final Random random=new Random();

                @Override
                public void run() {
                    System.out.println(getName()+"-开始运行");
                    try{
                        Thread.sleep(random.nextInt(1000));
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"-运行结束");
                    phaser.arrive();

                }
            }.start();
        }
        phaser.awaitAdvance(phaser.getPhase());
        System.out.println("主线程启动完毕");
        System.out.println("主线程运行结束");
    }

        //正常线程执行结果测试
   /* public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            new Thread("CountDownLatch线程-"+(i)){
                private final Random random=new Random();

                @Override
                public void run() {
                    System.out.println(getName()+"-开始运行");
                    try{
                        Thread.sleep(random.nextInt(1000));
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"-运行结束");
                }
            }.start();
        }
        System.out.println("主线程启动完毕");
        System.out.println("主线程运行结束");
    }*/




}
