package com.customer.thread.keywords;

/**
 * synchronized 关键字
 * @author sw
 *
 */
public class SynchronizedClass {
    /**
     * 锁如何实现？
     * 在对象头里，有一块数据叫Mark Word。在64位机器上，Mark Word是8字节（64位）的，这64位
     * 中有2个重要字段：锁标志位和占用该锁的thread ID。因为不同版本的JVM实现，对象头的数据结构会
     * 有各种差异。
     */
    public synchronized void  method1(){
        System.out.println("synchronized normal method" );
    }

    /**
     * 等驾于method1()方法  锁的是当前对象的函数
     */
    public  void  method11(){
        synchronized (this) {
            System.out.println("synchronized normal method");
        }
    }


    public synchronized static  void method2(){
        System.out.println("synchronized  static method" );
    }

    /**
     * 等价于method2()函数  锁的是当前类
     */
    public  static  void method22(){
        synchronized(SynchronizedClass.class) {
            System.out.println("synchronized  static method");
        }
    }
}
