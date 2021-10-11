package com.algorithmanddata;

import com.algorithmanddata.class1.BubbleSort;

/**
 * @className: ArrayUtil
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/9/11
 **/
public class ArrayUtil {
    /**
     *
     * @param length 长度
     * @param maxValue 最大值
     * @return 数组
     */
    public static int [] createArray(int length,int maxValue){
        int [] arr=new int[length];
        arr[0]=(int)(Math.random()*maxValue);
        for (int i=1;i<length;i++){
            arr[i]=(int) (Math.random()*maxValue);
        }
        return arr;
    }

    /**
     *
     * @param length 长度
     * @param maxValue 最大值
     * @return 数组
     */
    public static int [] createArraySortDesc(int length,int maxValue){
        int [] arr=new int[length];
        arr[0]=(int)(Math.random()*maxValue);
        for (int i=1;i<length;i++){
            do {
                arr[i]=(int) (Math.random()*maxValue);
            }while (arr[i]>arr[i-1]);
        }
        return arr;
    }

    /**
     *
     * @param length 长度
     * @param maxValue 最大值
     * @return 数组
     */
    public static int [] createArraySortAsc(int length,int maxValue){
        int [] arr=new int[length];
        arr[0]=(int)(Math.random()*maxValue);
        for (int i=1;i<length;i++){
            do {
                arr[i]=(int) ((Math.random()*maxValue)+1);
            }while (arr[i]==arr[i-1]);
        }
        BubbleSort.bubbleSort(arr);
        return arr;
    }



}
