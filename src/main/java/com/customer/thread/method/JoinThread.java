package com.customer.thread.method;

/**
 * join 线程关键字
 */
public class JoinThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("my thread  :"+i);
        }
    }
}
