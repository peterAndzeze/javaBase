package com.customer.thread.method;

/**
 * join 线程关键字
 */
public class JoinThread2 extends Thread {

    @Override
    public void run() {
        for (int i = -10; i < 0; i++) {
            System.out.println("my thread  :"+i);
        }
    }
}
