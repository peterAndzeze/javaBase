package com.customer.listNew;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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


}
