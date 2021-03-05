package com.customer.thread.syncutil.cycliBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 工作线程
 */
public class MyThread extends Thread {

    private final CyclicBarrier cyclicBarrier;
    private final Random random=new Random();
    public MyThread(String name,CyclicBarrier cyclicBarrier){
        super(name);
        this.cyclicBarrier=cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(2000));
            System.out.println(Thread.currentThread().getName()+"-已经到达公司");
            //等待笔试
            cyclicBarrier.await();
            Thread.sleep(random.nextInt(2000));
            System.out.println(Thread.currentThread().getName()+"-参加笔试");
            //等待面试
            cyclicBarrier.await();
            Thread.sleep(random.nextInt(2000));
            System.out.println(Thread.currentThread().getName()+"-已经面试结束");
            super.run();//不加不可以
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
