package com.customer.thread.keywords.volatilet;

/**
 * volatile 原子性测试
 */
public class VolatileAtomic {
    /***
     * volatile 不保证原子性
     * 原子性定义：数据的一致性 完整性
     */
    private volatile int number=0;

    /**
     * 增加
     */
    public void addPlus(){
        number++;
    }

    public static void main(String[] args) {
        VolatileAtomic volatileTest=new VolatileAtomic();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    volatileTest.addPlus();
                }
            },String.valueOf(i)).start();
        }
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
        /**
         * volatile不保证原子性原理分析
         * number++被拆分成3个指令
         * 执行GETFIELD拿到主内存中的原始值number
         * 执行IADD进行加1操作
         * 执行PUTFIELD把工作内存中的值写回主内存中
         * 当多个线程并发执行PUTFIELD指令的时候，会出现写回主内存覆盖问题，所以才会导致最终结果不为
         * 20000，volatile不能保证原子性。
         */
    }

}
