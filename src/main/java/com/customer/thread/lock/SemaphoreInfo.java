package com.customer.thread.lock;

/**
 * 信号量
 */
public class SemaphoreInfo {

    public void info(){
        /**
         * 上述两种锁机制类型都是“互斥锁”，学过操作系统的都知道，互斥是进程同步关系的⼀种特殊情况，相
         * 当于只存在⼀个临界资源，因此同时最多只能给⼀个线程提供服务。但是，在实际复杂的多线程应⽤程
         * 序中，可能存在多个临界资源，这时候我们可以借助Semaphore信号量来完成多个临界资源的访问。
         * Semaphore基本能完成ReentrantLock的所有⼯作，使⽤⽅法也与之类似，通过acquire()与release()⽅
         * 法来获得和释放临界资源。
         * 经实测，Semaphone.acquire()⽅法默认为可响应中断锁，与ReentrantLock.lockInterruptibly()作⽤效
         * 果⼀致，也就是说在等待临界资源的过程中可以被Thread.interrupt()⽅法中断。
         * 此外，Semaphore也实现了可轮询的锁请求与定时锁的功能，除了⽅法名tryAcquire与tryLock不同，其
         * 使⽤⽅法与ReentrantLock⼏乎⼀致。Semaphore也提供了公平与⾮公平锁的机制，也可在构造函数中
         * 进⾏设定。
         * Semaphore的锁释放操作也由⼿动进⾏，因此与ReentrantLock⼀样，为避免线程因抛出异常⽽⽆法正
         * 常释放锁的情况发⽣，释放锁的操作也必须在finally代码块中完成。
         */
    }


}
