package com.customer.thread.threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future=CompletableFuture.supplyAsync(()->{
            Person person=new Person();
            person.setName("张三");
            if(null==person.getName()){
                person.setFlag(false);
            }
            System.out.println("返回中间结果:"+person);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return person;
        }).thenApply(new Function<Person, String>() {
            @Override
            public String apply(Person p) {
                System.out.println("获取中间结果:"+p);
                if(!p.isFlag()){
                    return "参数验证失败";

                }
                return "参数验证成功";
            }
        });
        String validateStr=future.get();
        System.out.println("最终的结果为："+validateStr);
    }
}
