package com.customer.thread.syncutil.semaphore;

import java.util.Random;

/**
 * 抢占座位的线程
 */
public class MyNormalThread extends Thread {

    private final Random random=new Random();
    public MyNormalThread(String name){
        super(name);
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"-抢座位success,start writing work*******");
            Thread.sleep(random.nextInt(1000));
            System.out.println(Thread.currentThread().getName() + " - 作业完 成，腾出座位");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
