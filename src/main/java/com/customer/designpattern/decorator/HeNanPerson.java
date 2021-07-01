package com.customer.designpattern.decorator;

/**
 * 河南人
 */
public class HeNanPerson implements PersonSurvive {
    @Override
    public void eat() {
        System.out.println("河南人吃饭");
    }
}
