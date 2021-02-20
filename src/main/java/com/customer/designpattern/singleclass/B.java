package com.customer.designpattern.singleclass;

/**
 * 懒汉模式（此种方式 是线程不安全的）
 * 优点：该方法的确做到了用到即加载，也就是当调用getInstance的时候，才判断是否有该对象，如果不为
 * 空，则直接放回，如果为空，则新建一个对象并返回，达到了懒加载的效果。
 * 缺点：当多线程的时候，可能会产生多个实例。比如我有两个线程，同时调用getInstance方法，并都到了if语
 * 句，他们都新建了对象，那这里就不是单例的啦
 */
public class B {
    private B(){

    }
    private static B b;

    /**
     * 对外获取实例方法
     * @return
     */
    public static B getInstance(){
        if(null==b){
            b=new B();
        }
        return b;
    }

}
