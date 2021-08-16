package com.customer.reflection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @className: MethodHandleTest
 * @description: MethodHandle 测试
 * @author: sw
 * @date: 2021/7/12
 **/
public class MethodHandleTest {
    public static void main(String[] args) throws Throwable {
        MethodType mt = MethodType.methodType(String.class,String.class);
        MethodType ann = MethodType.methodType(CusAnnotaiton.class,Person.class);
        CusAnnotaiton annotation1 = Person.class.getAnnotation(CusAnnotaiton.class);
       // CusAnnotaiton  annotation = ann.returnType().getDeclaredAnnotation(CusAnnotaiton.class);
        System.out.println(annotation1.name());

        MethodHandle writeName = MethodHandles.lookup().findVirtual(Person.class, "writeName", mt);
        Object name = writeName.bindTo(new Person()).invoke("张三");
        System.out.println(name);
    }

}
