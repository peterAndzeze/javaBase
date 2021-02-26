package com.customer.thread.lock;

/**
 * 可重入锁（互斥）
 */
public class ReentrantLockInfo {
    /**
     * 内容简介
     */
    public void baseInfo(){
        /**
         * 可重⼊锁，顾名思义，这个锁可以被线程多次重复进⼊进⾏获取操作。
         * ReentantLock继承接⼝Lock并实现了接⼝中定义的⽅法，除了能完成synchronized所能完成的所有⼯作
         * 外，还提供了诸如可响应中断锁、可轮询锁请求、定时锁等避免多线程死锁的⽅法。
         * Lock实现的机理依赖于特殊的CPU指定，可以认为不受JVM的约束，并可以通过其他语⾔平台来完成底
         * 层的实现。在并发量较⼩的多线程应⽤程序中，ReentrantLock与synchronized性能相差⽆⼏，但在⾼
         * 并发量的条件下，synchronized性能会迅速下降⼏⼗倍，⽽ReentrantLock的性能却能依然维持⼀个⽔
         * 准。
         * 因此我们建议在⾼并发量情况下使⽤ReentrantLock。
         *
         * ReentrantLock引⼊两个概念：公平锁与⾮公平锁。
         * 公平锁指的是锁的分配机制是公平的，通常先对锁提出获取请求的线程会先被分配到锁。反之，JVM按
         * 随机、就近原则分配锁的机制则称为不公平锁。
         * ReentrantLock在构造函数中提供了是否公平锁的初始化⽅式，默认为⾮公平锁。这是因为，⾮公平锁
         * 实际执⾏的效率要远远超出公平锁，除⾮程序有特殊需要，否则最常⽤⾮公平锁的分配机制。
         * ReentrantLock通过⽅法lock()与unlock()来进⾏加锁与解锁操作，与synchronized会被JVM⾃动解锁机
         * 制不同，ReentrantLock加锁后需要⼿动进⾏解锁。为了避免程序出现异常⽽⽆法正常解锁的情况，
         * 使 ⽤ReentrantLock必须在finally控制块中进⾏解锁操作。通常使⽤⽅式如下所示：
         * Lock lock = new ReentrantLock();
         * try {
         * lock.lock();
         * //…进⾏任务操作5 }
         * finally {
         * lock.unlock();
         * }
         */
    }

}
