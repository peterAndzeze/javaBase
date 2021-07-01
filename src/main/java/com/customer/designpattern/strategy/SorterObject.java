package com.customer.designpattern.strategy;

/**
 * sort 排序
 */
public class SorterObject {
    public static void sort(CusCompare [] arr){
        for (int i = 0; i <arr.length ; i++) {
            int minPos=i;
            for (int j = i+1; j <arr.length ; j++) {
                minPos=arr[j].compareTo(arr[minPos])==-1?j:minPos;
            }
            swap(arr,i,minPos);
        }

    }

    /**
     * 交换
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(CusCompare [] arr,int i,int j){
        CusCompare temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
