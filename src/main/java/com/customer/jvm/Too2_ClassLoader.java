package com.customer.jvm;

public class Too2_ClassLoader {

    public static void main(String[] args) {
        /**
         * 得到String 这个class 被哪个classLoader加载
         * 任何一个class load内存中干两件事：1。将数据从磁盘加载到内存，另外生成一个class对象，指向这个内存
         * class对象 存在的位置可能是metaspace,是hotshot代码生成的
         */
        System.out.println(String.class.getClassLoader());

    }
}
