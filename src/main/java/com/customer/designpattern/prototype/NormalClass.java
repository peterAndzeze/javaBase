package com.customer.designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式
 * @author wodezuiaishinageren
 */
public class NormalClass implements Cloneable {
    public NormalClass() {
        System.out.println("构造函数执行");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    private String name ;
    private List<String> address=new ArrayList<>();
    public void setValue(String str){
        this.address.add(str);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}
