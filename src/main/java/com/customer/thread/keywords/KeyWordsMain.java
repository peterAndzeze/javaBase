package com.customer.thread.keywords;

/**
 * 线程关键字测试
 * @author sw
 */
public class KeyWordsMain {
    public static void main(String[] args) throws InterruptedException {

            Thread thread=new Thread(){
                @Override
                public void run(){
                    WaitNotifyClass waitNotifyClass=new WaitNotifyClass();
                    try {
                        waitNotifyClass.say();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        waitNotifyClass.answer();
                    }
                }
            };
            thread.start();
            System.exit(0);



    }
}
