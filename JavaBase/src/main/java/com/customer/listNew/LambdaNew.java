package com.customer.listNew;

import java.util.*;
import java.util.function.BiFunction;

/**
 * 函数式编程在java中在1.8之前通过内部类的形式进行实现
 */
public class LambdaNew {
    public void lambdaList(){
        Arrays.asList("a","b","c").forEach(
                e-> System.out.println(e)
        );
    }

    /**
     * 使用局部变量  默认转为final
     */
    public void lambdaUseProperty(){
        String name=",";
        Arrays.asList("a","b","c").forEach(
                e-> System.out.print(e+name)
        );
    }

    public void lambdaReturnValue(){
        List<Integer> ints=Arrays.asList(1,78,3,5,4);
        ints.sort(
                (a1,a2)-> {
                    int i=a1.compareTo(a2);
                    System.out.println("a1:" + a1+ ",a2:" + a2+",i:"+i);
                    return i;
                }
        );
        ints.forEach(e-> System.out.println(e));

    }

    public void listSort(){
        List<Integer> ints=Arrays.asList(1,78,3,5,4);
        Collections.sort(ints,(a1,b1)->a1.compareTo(b1));
        ints.forEach(i->System.out.print("正序结果："+i+" "));
        System.out.println("");
        Collections.sort(ints,(a1,b1)->b1.compareTo(a1));
        ints.forEach(i->System.out.print("倒序结果："+i+" "));

    }

    /**
     * map 操作
     */
    public void map(){
        Map<String,Integer> map=new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.forEach((k,v)-> System.out.println("key:"+k+",value:"+v));
       // map.computeIfPresent("a", k->2);
        map.compute("a",(k,v)->(v==null)?3:5);
        System.out.println(map.get("a"));
        System.out.println(map.computeIfPresent("b",(k,v)->(v>3)?5:6));

    }

}
