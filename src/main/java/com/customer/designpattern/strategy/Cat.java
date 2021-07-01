package com.customer.designpattern.strategy;

public class Cat implements CusCompare {
    int weight,height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }



    @Override
    public int compareTo(Object o) {
        Cat  c=(Cat)o;
        if(this.weight>=c.weight ){
            return 1;
        }
        if(this.height<c.height){
            return -1;
        }
        return 0;
    }
}
