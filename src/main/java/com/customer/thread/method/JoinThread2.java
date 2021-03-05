package com.customer.thread.method;

import java.util.Random;

/**
 * join 线程关键字
 */
public class JoinThread2 extends Thread {
    public JoinThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = -10; i < 0; i++) {
            System.out.println(getName()+"  :"+i);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
