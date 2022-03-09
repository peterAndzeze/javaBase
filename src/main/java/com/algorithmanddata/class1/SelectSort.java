package com.algorithmanddata.class1;

/**
 * @className: selectSort
 * @description: 选择排序
 * @author: sw
 * @date: 2021/9/6
 **/
public class SelectSort {
    /**
     * 选择排序
     * @param array
     */
    public static void selectSort(int[] array){
        if(null==array || array.length<2){
            return;
        }
        /**
         * 执行顺序
         * 0~n-1
         * 1~n-1
         *
         */
        int length=array.length;
        for (int i=0;i<length;i++){
            int minValueIndex=i;
            for(int j=i+1;j<length;j++){
                minValueIndex=array[j]>array[minValueIndex]?j:minValueIndex;
            }
            com.algorithmanddata.class1.Code01_Sort.swapData(array,i,minValueIndex);
        }
    }
}
