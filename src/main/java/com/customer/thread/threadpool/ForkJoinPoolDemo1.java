package com.customer.thread.threadpool;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolDemo1 {
    static class SortTask extends RecursiveAction{
        final long [] array;
        final int lo;
        final int hi;

        public SortTask(long[] array) {
            this.array = array;
            this.lo=0;
            this.hi=array.length-1;
        }

        public SortTask(long[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }
        private int partition(long [] array,int lo,int hi){
            long x=array[hi];
            int i=lo-1;
            for (int j = lo; j <hi ; j++) {
                if(array[j]<=x){
                    i++;
                    swap(array,i,j);
                }
            }
            swap(array,i+1,hi);
            return i+1;
        }

        private void swap(long[] array, int i, int j) {
            if(i!=j){
                long temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }

        @Override
        protected void compute() {
            if(lo<hi){
                System.out.println("第一步:"+Thread.currentThread().getName()+"lo:"+lo+","+hi);
                //找到分区元素的下标
                int pivot=partition(array,lo,hi);
                SortTask left=new SortTask(array,lo,pivot-1);
                SortTask right=new SortTask(array,pivot+1,hi);
                left.fork();
                right.fork();
                left.join();
                right.join();

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long[] array = {5, 3, 7, 9, 2, 4, 1, 8, 10,5, 3, 7, 9, 2, 4, 1, 8, 10,5, 3, 7, 9, 2, 4, 1, 8, 10,5, 3, 7, 9, 2, 4, 1, 8, 10,5, 3, 7, 9, 2, 4, 1, 8, 10,5, 3, 7, 9, 2, 4, 1, 8, 10
        ,5, 3, 7, 9, 2, 4, 1, 8, 10,5, 3, 7, 9, 2, 4, 1, 8, 10,5, 3, 7, 9, 2, 4, 1, 8, 10,5, 3, 7, 9, 2, 4, 1, 8, 10,5, 3, 7, 9, 2, 4, 1, 8, 10,5, 3, 7, 9, 2, 4, 1, 8, 10,5, 3, 7, 9, 2, 4, 1, 8, 10};
        Long startTime=System.currentTimeMillis();
        // 一个任务
        ForkJoinTask sort = new SortTask(array);
        // 一个pool
        ForkJoinPool pool = new ForkJoinPool();
        // ForkJoinPool开启多个线程，同时执行上面的子任务
        pool.submit(sort);
        // 结束ForkJoinPool
        pool.shutdown();
        // 等待结束Pool
        pool.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(Arrays.toString(array));
        System.out.println("快排结束时间:"+(System.currentTimeMillis()-startTime));
        long sortStartTime=System.currentTimeMillis();
        int length=array.length;
        for (int i = 0; i < length; i++) {
            for (int j=0;j<length;j++){
                if(array[i]<array[j]){
                    long temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("冒泡排序时间:"+(System.currentTimeMillis()-sortStartTime));
    }

}
