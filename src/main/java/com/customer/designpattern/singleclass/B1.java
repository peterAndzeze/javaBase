package com.customer.designpattern.singleclass;

/**
 * 懒汉模式（线程安全）
 * 优点：该方法的确做到了用到即加载，也就是当调用getInstance的时候，才判断是否有该对象，如果不为
 * 空，则直接放回，如果为空，则新建一个对象并返回，达到了懒加载的效果。
 * 缺点：解决了线程安全的问题，但是性能很低，当并发上来的时候，所有的调用都会阻塞
 */
public class B1 {
    private B1(){

    }
    private static B1 b;

    /**
     * 对外获取实例方法
     * @return
     */
    public synchronized static B1 getInstance(){
        if(null==b){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b=new B1();
        }
        return b;
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(B1.getInstance().hashCode());
            }).start();
        }
    }

}
