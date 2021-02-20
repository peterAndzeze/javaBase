package com.customer.designpattern.singleclass;

/**
 * 双重检查（推荐）
 *具体来说，如果两个线程同时调用了getInstance方法，并且都已到达了if语句之后，synchronized语
 * 句之前，此时第一个线程进入synchronized之中，先判断是否为空，很显然第一次肯定为空，那么则新
 * 建了对象。等到第二个线程进入synchronized之中，先判断是否为空，显然第一个已经创建了，所以即
 * 不新建对象。下次，不管是一个线程或者多个线程，在第一个if语句那就判断出有对象了，便直接返回
 * 啦，根本进不了里面的代码
 */
public class C {
    private C(){

    }
    private volatile static C c;

    /**
     * 对外获取实例方法
     * 看下面的方法说下指令重排的概念
     * 在说下volatile作用：一旦假设发生了这样的重排序，比如线程A在执行了步骤1和步骤3，但是步骤2还没有执行完。这个时
     * 候线程B有进入了第一个if语句，它会判断a不为空，即直接返回了a。其实这是一个未初始化完成的a，
     * 即会出现问题。所以我们会将入volatile关键字，来禁止这样的重排序，即可正常运行
     * @return
     */
    public  static C getInstance(){
        if(null==c){
            synchronized (C.class) {
                if(null==c){
                    c = new C();
                }
            }
        }
        return c;
    }

    /**
     * 先来看一个概念, 重排序 ，也就是语句的执行顺序会被重新安排。其主要分为三种：
     * 1.编译器优化的重排序：可以重新安排语句的执行顺序。
     * 2.指令级并行的重排序：现代处理器采用指令级并行技术，将多条指令重叠执行。
     * 3.内存系统的重排序：由于处理器使用缓存和读写缓冲区，所以看上去可能是乱序的。
     * 上面代码中的c = new C();可能被被JVM分解成如下代码
     */
    public void orderSort(){
        // 可以分解为以下三个步骤
        // 1 分配内存相当于c的malloc
        // memory=allocate();
         //2初始化对象
        //ctorInstanc(memory)
        // 3 设置s指向刚分配的地址
        // s=memory
        // 上述三个步骤可能会被重排序为 1-3-2，
        // 也就是： 1 memory=allocate();// 分配内存 相当于c的malloc
        // 3 s=memory //设置s指向刚分配的地址
        // 2 ctorInstanc(memory) //初始化对象
    }


}
