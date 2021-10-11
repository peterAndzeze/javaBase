package com.algorithmanddata.class3;

/**
 * @className: Code01_GetNum
 * @description: 一个无序数组，且相邻不等 ，从中找出任意一个局部最小值
 * 局部最小值概念：比左右都小
 *
 * @author: sw
 * @date: 2021/9/11
 **/
public class Code01_GetNum {
    /**
     * 模拟创建数组
     * @param length
     * @param maxValue
     * @return
     */
    public static int[] createArr(int length,int maxValue){
        if(length<=0){
            return new int[length];
        }
        int [] arr=new int[length];
        arr[0] = (int) (Math.random() * maxValue);
        for(int i=1;i<length;i++ ){
            do {
                arr[i]=(int)(Math.random()*maxValue);
            }while (arr[i]==arr[i-1]);
        }
        return arr;
    }

    /**
     * 找出局部最小
     * @param arr 数组
     * @return 局部最小下标
     */
    public static int getMinIndex(int [] arr){
        int length=arr.length;
        if(length==1){
            return 0;
        }
        /*if(arr[0]<arr[1]){
            return 0;
        }
        if(arr[length-1]<arr[length-2]){
            return length-1;
        }*/
        int l=0;
        int r=length-1;
        // l <r-1 是保证取的中间节点 开闭区间落在l ～ r 之间
        while (l<r-1){
            int mid=(l+r)/2;
            if(arr[mid]<arr[mid+1] && arr[mid]<arr[mid-1]){
                return mid;
            }else{
                //舍弃mid右边数据，r值更新
                if(arr[mid]>arr[mid-1]){
                    r=mid-1;
                }else{
                    //舍弃mid左边数据，l值更新
                    l=mid+1;
                }
            }
        }
       return arr[l]<arr[r]?l:r;
    }



    public static void printArr(int [] arr){
        for (int a:arr){
            System.out.print(a+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int length=10;
        int maxValue=200;
        int testTimes=1;
        for(int i=0;i<testTimes;i++) {
            int[] arr = createArr(length, maxValue);
            printArr(arr);
            int minIndex = getMinIndex(arr);
            System.out.println("下标："+minIndex+",值："+arr[minIndex]);

        }
    }



}
