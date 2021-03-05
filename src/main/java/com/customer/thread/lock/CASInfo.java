package com.customer.thread.lock;

/**
 * Aqs
 */
public class CASInfo {

    public void info(){
        /**
         * 在Unsafe类中，只提供了三种类型的CAS操作：int、long、Object（也就是引用类型）。如下所
         * 示：
         */

    }

    public static void main(String[] args) {
        String  a;
        for (int i = 0; i <10 ; i++) {
            a=i+"";
            System.out.println(a.getClass().hashCode());
        }

    }


}
