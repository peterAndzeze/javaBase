package com.customer.thread.syncutil.contdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 工作线程
 */
public class MyThread extends Thread {

    private final CountDownLatch latch;
    private final Random random=new Random();
    public MyThread(String name,CountDownLatch countDownLatch){
        super(name);
        this.latch=countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(2000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"stop run**********");
        latch.countDown();
    }
}
