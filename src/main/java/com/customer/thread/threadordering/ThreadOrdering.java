package com.customer.thread.threadordering;

/**
 * @className: ThreadOrdering
 * @description: 线程有序性
 * @author: sw
 * @date: 2021/7/10
 **/
public class ThreadOrdering {
    private int num;
    public ThreadOrdering(){
        new Thread(()->{
            System.out.println(this.num);
        }).start();
    }
    public static void main(String [] args){
        ThreadOrdering t=new ThreadOrdering();
        t.num=8;

    }


}
