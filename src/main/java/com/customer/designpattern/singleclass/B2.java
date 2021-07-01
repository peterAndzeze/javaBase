package com.customer.designpattern.singleclass;

/**
 * 懒汉模式（线程不安全）
 * 优点：该方法的确做到了用到即加载，也就是当调用getInstance的时候，才判断是否有该对象，如果不为
 * 空，则直接放回，如果为空，则新建一个对象并返回，达到了懒加载的效果。
 * 缺点：这个没有意义，并没有解决多线程的问题。我们可以看到如果两个线程同时调用getInstance方法，并
 * 且都已经进入了if语句，即synchronized的位置，即便同步了，第一个线程先执行，进入synchronized
 * 同步的代码块，创建了对象，另一个进入等待状态，等第一个线程执行结束，第二个线程还是会进入
 * synchronized同步的代码块，创建对象。这个时候我们可以发现，对这代码块加了synchronized没有
 * 任何意义，还是创建了多个对象，并不符合单例
 */
public class B2 {
    private B2(){

    }
    private static B2 b;

    /**
     * 对外获取实例方法
     * @return
     */
    public  static B2 getInstance(){
        if(null==b){
            synchronized (B2.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b = new B2();
            }
        }
        return b;
    }


    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(B2.getInstance().hashCode());
            }).start();
        }
    }
}
