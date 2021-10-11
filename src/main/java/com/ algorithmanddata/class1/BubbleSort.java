package com.algorithmanddata.class1;

/**
 * @className: BubbleSort
 * @description: 冒泡排序
 * @author: sw
 * @date: 2021/9/6
 **/
public class BubbleSort {

    /**
     * 冒泡
     * @param array
     */
    public static void bubbleSort(int [] array){
        if(null==array || array.length<2){
            return;
        }
        int length=array.length;
        for (int i = length-1; i >=0; i--) {
            for(int j=1;j<=i;j++){
                if(array[j-1]>array[j]) {
                    com.algorithmanddata.class1.Code01_Sort.swapData(array, j - 1, j);
                }

            }
        }
    }

    /**
     * 冒泡
     * @param array
     */
    public static void bubbleDescSort(int [] array){
        if(null==array || array.length<2){
            return;
        }
        int length=array.length;
        for (int i = length-1; i >=0; i--) {
            for(int j=1;j<=i;j++){
                if(array[j-1]<array[j]) {
                    com.algorithmanddata.class1.Code01_Sort.swapData(array, j - 1, j);
                }

            }
        }
    }
}
