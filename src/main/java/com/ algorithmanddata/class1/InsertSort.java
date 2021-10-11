package com.algorithmanddata.class1;

/**
 * @className: insertSort
 * @description: 插入排序
 * @author: sw
 * @date: 2021/9/6
 **/
public class InsertSort {

    /**
     * 插入排序
     * @param array
     */
    public static void inertSort1(int [] array){
        int length = array.length;
        for (int i=0;i<length;i++){
            int index=i;
            while ((index-1)>=0 && array[index-1]>array[index]){
                com.algorithmanddata.class1.Code01_Sort.swapData(array,index-1,index);
                index--;
            }
        }
    }


    public static void inertSort2(int [] array){
        int length = array.length;
        for (int i=0;i<length;i++){
            for(int pre=i-1;pre>=0 && array[pre]>array[pre+1];pre-- ){
                com.algorithmanddata.class1.Code01_Sort.swapData(array,pre,pre+1);
            }
        }
    }
}
