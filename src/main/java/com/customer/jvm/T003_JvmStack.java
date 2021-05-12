package com.customer.jvm;

/**
 * java 虚拟机栈
 */
public class T003_JvmStack {
    public static void main(String[] args) {
        int i=8;
        i=i++;
        //i=++i;
        System.out.println(i);
    }
}
