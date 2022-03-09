package com.algorithmanddata.class3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @className: Code03_Hash
 * @description: 哈希表 无论多少数据量 都是常数计算的时间
 * @author: sw
 * @date: 2021/9/13
 **/
public class Code03_Hash {
    public static void main(String[] args) {
        /**
         * hash 基础数据类型内部是值传递，也就是只比对值信息
         * 非基础数据类型是按引用传递，即比对的是内存地址（重写会改变）
         * 一个hash节点 节点大小 16字节
         */
        Map<Integer,String> map=new HashMap<>();
        Integer a=123;
        Integer b=123;
        map.put(a,"asd");


        TreeMap<Integer,String> treeMap=new TreeMap<>();

        treeMap.put(1,"1");
        treeMap.put(2,"2");
        treeMap.put(4,"4");

        System.out.println(treeMap.higherKey(3));


    }
}
