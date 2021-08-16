package com.customer.reflection;

/**
 * @className: Person
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/12
 **/
@CusAnnotaiton(name = "asd")
public class Person {
    private String name;
    public String writeName(String name){
        System.out.println("my name is "+name);
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
