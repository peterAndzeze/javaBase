package com.customer.function;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @className: LambadaTest
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/9/30
 **/
public class LambadaTest {
    public static void main(String[] args) {
        Runnable noArguments=()->{
            System.out.println("一个线程:"+Thread.currentThread().getName());
        };
        noArguments.run();

        Predicate<Integer> altest=x->x>5;
        System.out.println(altest.test(new Integer(5)));
        Artist artist=new Artist();
        artist.setName("tom");
        Artist artist1=new Artist();
        artist1.setName("jerry");
        List<Artist> artists= Arrays.asList(artist,artist1);
        long jerry = artists.stream().filter(a -> a.isForm("jerry")).count();
        System.out.println(jerry);
        String [] arr={"a", "b", "c"};
        List<String> collect = Stream.of(arr).collect(Collectors.toList());
        collect.forEach(System.out::println);
        List<String> collect1 = Stream.of(arr).map(String::toUpperCase)
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);

        List<String> collect3 = Stream.of(Arrays.asList("a", "b"), Arrays.asList("c", "d"))
                .flatMap(Collection::stream).collect(Collectors.toList());
        collect3.forEach(System.out::println);



    }

}
 class  Artist{
    private String name;
    public boolean isForm(String name){
        return this.name.equals(name);
    }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }
 }

