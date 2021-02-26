package com.customer.thread.syncutil.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 抢占座位的线程
 */
public class MyThread extends Thread {

    private final Semaphore semaphore;
    private final Random random=new Random();
    public MyThread(String name,Semaphore semaphore){
        super(name);
        this.semaphore=semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"-抢座位success,start writing work*******");
            Thread.sleep(random.nextInt(1000));
            System.out.println(Thread.currentThread().getName() + " - 作业完 成，腾出座位");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        semaphore.release();
    }
}
