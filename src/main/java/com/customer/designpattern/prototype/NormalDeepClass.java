package com.customer.designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式
 * @author wodezuiaishinageren
 */
public class NormalDeepClass implements Cloneable {
    private String name ;
    private ArrayList<String> address=new ArrayList<>();
    public NormalDeepClass() {
        System.out.println("构造函数执行");
    }

    @Override
    protected NormalDeepClass clone() throws CloneNotSupportedException {

        NormalDeepClass clone = (NormalDeepClass) super.clone();
        clone.address=(ArrayList<String>)this.address.clone();
        return clone;
    }



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

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }
}
