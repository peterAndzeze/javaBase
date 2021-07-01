package com.customer.designpattern.strategy;

public class Dog implements CusCompare {
    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Object o) {
        Dog d=(Dog)o;
        if(this.food>d.food){
            return 1;
        }
        if(this.food<d.food){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
