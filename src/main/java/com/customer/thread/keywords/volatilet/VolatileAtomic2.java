package com.customer.thread.keywords.volatilet;

/**
 *  保证原子性
 */
public class VolatileAtomic2 {
    /***
     * volatile 不保证原子性
     * 原子性定义：数据的一致性 完整性
     */
    private volatile int number=0;

    /**
     * 第一种方式 增加synchronized 关键字
     */
    public synchronized void addPlus(){
        number++;
    }

    public static void main(String[] args) {
        VolatileAtomic2 volatileTest=new VolatileAtomic2();
        synchronizedMethod(volatileTest);
        /**
         * 默认后台两个线程 一个main 一个GC
         */
        while (Thread.activeCount()>2){
            /**
             * 等待其他线程执行完毕 在执行main 和GC线程
             */
            Thread.yield();
        }
        // 如果volatile保证原子性的话，最终的结果应该是20000
        // 执行多次后每次程序执行结果不一定是20000
        System.out.println(Thread.currentThread().getName()+"\t result: "+volatileTest.number);
    }

    public static void synchronizedMethod(VolatileAtomic2 volatileTest){
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    volatileTest.addPlus();
                }
            },String.valueOf(i)).start();
        }

    }


}
