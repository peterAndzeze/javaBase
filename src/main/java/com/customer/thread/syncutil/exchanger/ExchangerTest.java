package com.customer.thread.syncutil.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * exchanger 用于线程之间的交换数据，
 */
public class ExchangerTest {
    private final static Random random=new Random();
    public static void main(String[] args) {
        /**
         * 1、创建一个多线程共用的Exchange对象
         * 2、把exchange对象传递给3个线程对象，每个线程在自己的run方法中调用exchange，
         *把自己的数据作为参数传递进去，返回值是另外一个线程调用exchang传进去的参数
         */
        Exchanger<String> exchanger=new Exchanger<>();
        //threadTest(exchanger);
        new Thread("线程1"){
            @Override
            public void run(){
                while (true){
                    try{
                        String otherData = exchanger.exchange("交换数据1");
                        System.out.println(Thread.currentThread().getName()+"得到<=="+otherData);
                        Thread.sleep(random.nextInt(2000));
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("线程2"){
            @Override
            public void run(){
                while (true){
                    try{
                        String otherData = exchanger.exchange("交换数据2");
                        System.out.println(Thread.currentThread().getName()+"得到<=="+otherData);
                        Thread.sleep(random.nextInt(2000));
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("线程3"){
            @Override
            public void run(){
                while (true){
                    try{
                        String otherData = exchanger.exchange("交换数据3");
                        System.out.println(Thread.currentThread().getName()+"得到<=="+otherData);
                        Thread.sleep(random.nextInt(2000));
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    public static void threadTest( Exchanger<String> exchanger){
        for (int i = 0; i <3 ; i++) {
            new MyThread("当前线程:"+(i),exchanger,"data:"+i).start();
        }
    }


}
