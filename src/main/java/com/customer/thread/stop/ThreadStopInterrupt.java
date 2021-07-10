package com.customer.thread.stop;

import com.customer.thread.SleepHelper;

/**
 * @className: ThreadStopInterrupt
 * @description: interrupt 和volatile一样
 * @author: sw
 * @date: 2021/7/9
 **/
public class ThreadStopInterrupt {
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            long i=0;
            while (!Thread.interrupted()){
                i++;
            }
            System.out.println(i+"****");
        });
        thread.start();
        SleepHelper.sleepSeconds(1);
        thread.interrupt();
    }
//1574111904
}
