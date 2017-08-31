package com.customer.array;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * jk1.8中的并行数组
 */
public class ParallelArray {
    /**
     * 并行数组执行
     */
    public void parallelArray(){
        Long [] longsArr=new Long[20];
        Arrays.parallelSetAll(longsArr,index-> ThreadLocalRandom.current().nextLong(30));
        System.out.println("无序数数组");
        Arrays.stream(longsArr).forEach(i-> System.out.print(i+","));
        System.out.println();
        Arrays.parallelSort(longsArr);//排序
        System.out.println("排序后：");
        Arrays.stream(longsArr).limit(10).forEach(i-> System.out.print(i+","));

    }
}
