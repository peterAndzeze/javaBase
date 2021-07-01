package com.customer.designpattern.strategy.strageimpl;


/**
 * sort 排序
 */
public class SorterComparator<T> {
    public  void sort(T[] arr, CusComparator<T> cusComparator){
        for (int i = 0; i <arr.length ; i++) {
            int minPos=i;
            for (int j = i+1; j <arr.length ; j++) {
                minPos=cusComparator.compareTo(arr[j],arr[minPos])==-1?j:minPos;
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
    public  void swap(T [] arr,int i,int j){
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
