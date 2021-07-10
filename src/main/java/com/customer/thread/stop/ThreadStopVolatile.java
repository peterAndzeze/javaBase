package com.customer.thread.stop;

import com.customer.thread.SleepHelper;

/**
 * @className: ThreadStopVolatile
 * @description: volatile 停止线程，不能保证每次位置都一样
 * @author: sw
 * @date: 2021/7/9
 **/
public class ThreadStopVolatile {

    private static volatile  boolean running=true;

    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            long i=0;
            while (running){
                i++;
            }
            System.out.println(i+"****");
        });
        thread.start();
        SleepHelper.sleepSeconds(1);
        running=false;
    }


}
