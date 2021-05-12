package com.customer.jvm;

/**
 * 缓存行
 */
public class T002CacheLinePadding {
        public static class T{
            //8个字节
            private volatile long x=0L;
        }
        private static T [] arr=new T[2];
        static {
            arr[0]=new T();
            arr[1]=new T();
        }




    public static void main(String[] args) throws InterruptedException {
        normalLine();
        paddingLine();
    }
    public static void normalLine() throws InterruptedException {
        Thread thread1=new Thread(()->{
            for (long i = 0; i <1000_0000L ; i++) {
                //volatile的缓存一致性协议MESI或者锁总线，会消耗时间 不同的数据在同一个内存行
                arr[0].x=i;
            }
        });
        Thread thread2 = new Thread(()->{
            for(long i = 0;i< 1000_0000L;i++){
                arr[1].x = i;
            }
        });
        long startTime = System.nanoTime();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("总计消耗时间："+(System.nanoTime()-startTime)/100_000);
    }
    /***********升级行************************/

    private static UpT [] arrN=new UpT[2];
    static {
        arrN[0]=new UpT();
        arrN[1]=new UpT();
    }
    private static class Padding {
        /**
         * 预先填充8个字节
         */
        public  volatile long p1,p2,p3,p4,p5,p6,p7;
    }

    public static class UpT extends Padding{
        private volatile long x=0L;
    }

    public static void paddingLine() throws InterruptedException {
        Thread thread1=new Thread(()->{
            for (long i = 0; i <1000_0000L ; i++) {
                //volatile的缓存一致性协议MESI或者锁总线，会消耗时间 不同的数据在同一个内存行
                arrN[0].x=i;
            }
        });
        Thread thread2 = new Thread(()->{
            for(long i = 0;i< 1000_0000L;i++){
                arrN[1].x = i;
            }
        });
        long startTime = System.nanoTime();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("总计消耗时间："+(System.nanoTime()-startTime)/100_000);
    }
}
