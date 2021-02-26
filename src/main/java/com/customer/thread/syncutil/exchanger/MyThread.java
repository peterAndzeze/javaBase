package com.customer.thread.syncutil.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * 工作线程
 */
public class MyThread extends Thread {
    private static final Random random=new Random();
    private final Exchanger<String> exchanger;
    private String data;

    public MyThread(String name,Exchanger<String> exchanger,String data) {
        super(name);
        this.exchanger = exchanger;
        this.data=data;
    }

    @Override
    public void run() {
        while (true){
            try{
                String otherData = exchanger.exchange(data);
                System.out.println(Thread.currentThread().getName()+"得到<=="+otherData);
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
