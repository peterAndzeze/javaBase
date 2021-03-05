package com.customer.thread.syncutil.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量同步
 *
 * 当初始的资源个数为1的时候，Semaphore退化为排他锁。正因为如此，Semaphone的实现原理和
 * 锁十分类似，是基于AQS，有公平和非公平之分
 */
public class SemaphoreTest {
    /**
     * 信息简介
     */
    public static void info() {
        /**
         * 有5份共享资源 ，第二个参数表示是否公平
         */
        Semaphore myresources=new Semaphore(5,true);
        try {
            /**
             * 工作线程每获取一份资源信息，就在该对象上记录下来，
             * 在获取的时候公平与否，根据构造函数第二个参数值进行判断
             */
            myresources.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 工作线程每归还一份资源，就在该对象上记录
         * 此时资源信息可以被其他线程shying
         * 另外的函数myresources.release(2),释放指定数目的许可，
         * 并将它们归还给信标。 可用许可数加上该指定数目。 如果线程需要获取N个许可，
         * 在有N个许可可用之前，该线程阻塞。 12345678910111213141516
         *
         */
        myresources.release();


        /*从信标获取指定数目的许可。如果可用许可数目不够，则线程阻塞，直到被中断。
         该方法效果与循环相同， for (int i = 0; i < permits; i++) acquire();
          只不过该方法是原子操作。 如果可用许可数不够，则当前线程阻塞，直到：（二选一）
          1. 如果其他线程释放了许可，并且可用的许可数满足当前线程的请求数字；
          2. 其他线程中断了当前线程。 permits – 要获取的许可数
          */
        try {
            myresources.acquire(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * 场景测试
     */

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        for (int i = 0; i <5 ; i++) {
           new MyThread("学生-"+(i+1),semaphore).start();
        }

        for (int i = 0; i <5 ; i++) {
            //new MyNormalThread("normal学生-"+(i+1)).start();
        }
    }

}
