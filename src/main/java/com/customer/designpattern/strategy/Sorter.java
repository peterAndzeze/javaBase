package com.customer.designpattern.strategy;

/**
 * sort 排序
 */
public class Sorter {
    public static void sort(int [] arr){
        for (int i = 0; i <arr.length ; i++) {
            int minPos=i;
            for (int j = i+1; j <arr.length ; j++) {
                minPos=arr[j]<arr[minPos]?j:minPos;
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
    public static void swap(int [] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
