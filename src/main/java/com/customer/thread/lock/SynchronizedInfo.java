package com.customer.thread.lock;

/**
 * 同步锁 互斥
 */
public class SynchronizedInfo {
    /**
     * 在Java中synchronized关键字被常⽤于维护数据⼀致性。
     * synchronized机制是给共享资源上锁，只有拿到锁的线程才可以访问共享资源，这样就可以强制使得对
     * 共享资源的访问都是顺序的。
     * Java开发⼈员都认识synchronized，使⽤它来实现多线程的同步操作是⾮常简单的，只要在需要同步的
     * 对⽅的⽅法、类或代码块中加⼊该关键字，它能够保证在同⼀个时刻最多只有⼀个线程执⾏同⼀个对象
     * 的同步代码，可保证修饰的代码在执⾏过程中不会被其他线程⼲扰。使⽤synchronized修饰的代码具有
     * 原⼦性和可⻅性，在需要进程同步的程序中使⽤的频率⾮常⾼，可以满⾜⼀般的进程同步要求。
     * synchronized (obj) {
     * //⽅法
     * …….
     * }
     * synchronized实现的机理依赖于软件层⾯上的JVM，因此其性能会随着Java版本的不断升级⽽提⾼。
     * 到了Java1.6，synchronized进⾏了很多的优化，有适应⾃旋、锁消除、锁粗化、轻量级锁及偏向锁等，
     * 效率有了本质上的提⾼。在之后推出的Java1.7与1.8中，均对该关键字的实现机理做了优化。
     * 需要说明的是，当线程通过synchronized等待锁时是不能被Thread.interrupt()中断的，因此程序设计时
     * 必须检查确保合理，否则可能会造成线程死锁的尴尬境地。
     * 最后，尽管Java实现的锁机制有很多种，并且有些锁机制性能也⽐synchronized⾼，但还是强烈推荐在
     * 多线程应⽤程序中使⽤该关键字，因为实现⽅便，后续⼯作由JVM来完成，可靠性⾼。只有在确定锁机
     * 制是当前多线程程序的性能瓶颈时，才考虑使⽤其他机制，如ReentrantLock等。
     */

}
