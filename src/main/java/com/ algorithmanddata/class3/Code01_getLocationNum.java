package com.algorithmanddata.class3;

import com.algorithmanddata.ArrayUtil;

/**
 * @className: Code01_getLocationNum
 * @description: 定义数字N 一个有序数组，找出数组中比N 大的最左/右边的数据
 * @author: sw
 * @date: 2021/9/11
 **/
public class Code01_getLocationNum {


    public static void printArr(int [] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print("index:"+i+"，value:"+arr[i]+" \t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int length=10;
        int maxValue=300;
        int[] arraySortAsc = ArrayUtil.createArraySortAsc(length,maxValue);
        printArr(arraySortAsc);
    }


}
