package com.algorithmanddata.class1;

/**
 * @className: Code01_Sort
 * @description: 简单排序
 * @author: sw
 * @date: 2021/9/1
 **/
public class Code01_Sort {

    public static void main(String[] args) {
        int [] array={3,12,3,4,5,1,5,2,5,6,8};
        printArray(array);
        //selectSort(array);
        //bubbleSort(array);
        //inertSort1(array);
        com.algorithmanddata.class1.InsertSort.inertSort2(array);
        printArray(array);
    }


    /**
     * 交换数据
     * @param array
     * @param i
     * @param temp
     */
    public static void swapData(int[] array, int i, int temp) {
        int a=array[i];
        array[i]=array[temp];
        array[temp]=a;
    }


    /**
     * 打印
     * @param array
     */
    public static void printArray(int [] array){
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println();
    }



}
