package com.customer.thread.syncutil.cycliBarrier;

import java.util.Random;

/**
 * 工作线程
 */
public class MyNormalThread extends Thread {

    private final Random random=new Random();
    public MyNormalThread(String name){
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(2000));
            System.out.println(Thread.currentThread().getName()+"-已经到达公司");

            Thread.sleep(random.nextInt(2000));
            System.out.println(Thread.currentThread().getName()+"-参加笔试");

            Thread.sleep(random.nextInt(2000));
            System.out.println(Thread.currentThread().getName()+"-已经面试结束");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
