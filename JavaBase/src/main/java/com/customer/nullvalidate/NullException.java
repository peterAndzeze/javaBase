package com.customer.nullvalidate;

import java.util.Optional;
import java.util.function.Supplier;

public class NullException {
    /**
     * 空指针异常控制
     */
    public void validateNull(){
        String name="aa";
        String key=null;
        Optional<String> optional= Optional.ofNullable(name);
        System.out.println(optional.isPresent());//是否为空
        System.out.println(optional.get());//不为空返回vale
        System.out.println("如果不为空返回value："+optional.orElse(key));
        Optional<String> optional1= Optional.ofNullable(key);
        System.out.println(optional1.orElseGet(()->"张三"));

    }
}
