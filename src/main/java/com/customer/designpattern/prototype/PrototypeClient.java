package com.customer.designpattern.prototype;

import java.util.Arrays;

/**
 * 原型模式测试类
 */
public class PrototypeClient {
    public static void main(String[] args) throws CloneNotSupportedException {
        //normalClone();
        //qianClone();
        deepClone();
    }


    /**
     * 深拷贝
     */
    public static void deepClone() throws CloneNotSupportedException {
        NormalDeepClass normalClass=new NormalDeepClass();
        normalClass.setName("里斯");
        normalClass.setValue("漳州");
        //构造函数不执行
        NormalDeepClass clone = (NormalDeepClass) normalClass.clone();
        clone.setName("张三");
        clone.setValue("杭州");
        System.out.println(clone.getAddress().size());
        System.out.println(normalClass.getAddress().size());
    }
    /**
     * 浅拷贝
     */
    public static void qianClone() throws CloneNotSupportedException {
        NormalClass normalClass=new NormalClass();
        normalClass.setName("里斯");
        normalClass.setValue("漳州");
        //构造函数不执行
        NormalClass clone = (NormalClass) normalClass.clone();
        clone.setName("张三");
        clone.setValue("杭州");
        System.out.println(clone.getAddress().size());
        System.out.println(normalClass.getAddress().size());
    }



    /**
     * 普通拷贝
     */
    public static void normalClone(){
        NormalClass normalClass=new NormalClass();
        normalClass.setName("里斯");
        normalClass.setValue("漳州");
        try {
            //构造函数不执行
            NormalClass clone = (NormalClass) normalClass.clone();

            clone.setName("张三");
            clone.setAddress(Arrays.asList("杭州"));
            System.out.println(normalClass.getName()+"::"+clone.getName());
            for (String str:normalClass.getAddress()){
                System.out.print("\t"+str);
            }

            for (String str:clone.getAddress()){
                System.out.print("\t"+str);
            }


        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
