package com.customer.thread.threadimp;

import java.util.concurrent.FutureTask;

/**
 * 线程实现方式测试主类
 * @author sw
 */
public class ImplementsThreadMain {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.run();
        MyRunnable myRunnable=new MyRunnable();
        Thread runnable=new Thread(myRunnable);
        runnable.start();
        ImplementsCallable implementsCallable=new ImplementsCallable();
        try {
            FutureTask<String> futureTask=new FutureTask<>(implementsCallable);
            new Thread(futureTask).start();
            String call = futureTask.get();
            System.out.println("callable is return "+call);
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }
    /****
     * 技术描述：
     * 1. 所有的Java 程序，不论并发与否，都有一个名为主线程的Thread 对象。执行该程序时， Java
     * 虚拟机（ JVM ）将创建一个新Thread 并在该线程中执行main()方法。这是非并发应用程序中
     * 唯一的线程，也是并发应用程序中的第一个线程。
     * 2. Java中的线程共享应用程序中的所有资源，包括内存和打开的文件，快速而简单地共享信息。
     * 但是必须使用同步避免数据竞争。
     * 3. Java中的所有线程都有一个优先级，这个整数值介于Thread.MIN_PRIORITY（1）和
     * Thread.MAX_PRIORITY（10）之间，默认优先级是Thread.NORM_PRIORITY（5）。线程的
     * 执行顺序并没有保证，通常，较高优先级的线程将在较低优先级的钱程之前执行。
     * 4. 在Java 中，可以创建两种线程：区别在于它们如何影响程序的结束。
     *      守护线程。
     *      非守护线程。
     * 5. Java程序结束执行过程的情形：
     *      程序执行Runtime类的exit()方法， 而且用户有权执行该方法。
     * 应用程序的所有非守护线程均已结束执行，无论是否有正在运行的守护线程。
     * 守护线程通常用在作为垃圾收集器或缓存管理器的应用程序中，执行辅助任务。在线程start之前调
     * 用isDaemon()方法检查线程是否为守护线程，也可以使用setDaemon()方法将某个线程确立为守护线
     * 程。
     *
     * 6. Thread.States类中定义线程的状态如下：
     *      NEW：Thread对象已经创建，但是还没有开始执行。
     *      RUNNABLE：Thread对象正在Java虚拟机中运行。
     *      BLOCKED : Thread对象正在等待锁定。
     *      WAITING：Thread 对象正在等待另一个线程的动作。
     *      TIME_WAITING：Thread对象正在等待另一个线程的操作，但是有时间限制。
     *      TERMINATED：Thread对象已经完成了执行。
     *      getState()方法获取Thread对象的状态，可以直接更改线程的状态。
     * 在给定时间内， 线程只能处于一个状态。这些状态是JVM使用的状态，不能映射到操作系统的线程
     * 状态。
     * Runnable 和Thread 类
     *      Runnable接口只定义了一种方法：run()方法。这是每个线程的主方法。当执行start()方法启动新线
     * 程时，它将调用run()方法。
     *      Thread类其他常用方法：
     *              获取和设置Thread对象信息的方法。
     *              getId()：该方法返回Thread对象的标识符。该标识符是在钱程创建时分配的一个正
     *                  整数。在线程的整个生命周期中是唯一且无法改变的。
     *              getName()/setName()：这两种方法允许你获取或设置Thread对象的名称。这个名
     *                  称是一个String对象，也可以在Thread类的构造函数中建立。
     *              getPriority()/setPriority()：你可以使用这两种方法来获取或设置Thread对象的优先
     * 级。
     *              isDaemon()/setDaemon()：这两种方法允许你获取或建立Thread对象的守护条件。
     *              getState()：该方法返回Thread对象的状态。
     *              interrupt()：中断目标线程，给目标线程发送一个中断信号，线程被打上中断标记。
     *              interrupted()：判断目标线程是否被中断，但是将清除线程的中断标记。
     *              isinterrupted()：判断目标线程是否被中断，不会清除中断标记。
     *              sleep(long ms)：该方法将线程的执行暂停ms时间。
     *              join()：暂停线程的执行，直到调用该方法的线程执行结束为止。可以使用该方法等待另一个
     *                  Thread对象结束。
     *              setUncaughtExceptionHandler()：当线程执行出现未校验异常时，该方法用于建立未校验异
     *                  常的控制器。
     *              currentThread()：Thread类的静态方法，返回实际执行该代码的Thread对象。
     *
     *
     *
     *
     *
     *
     *
     *
     */
}
