package com.customer.methoduse;

import java.util.function.Supplier;

public class Car {
    /**
     * 定义构造函数
     * @param supplier
     * @return
     */
    public static Car create(final Supplier<Car> supplier){
        Car car=supplier.get();
        System.out.println("construs class:"+car);
        return car;
    }

    /**
     * 车被撞了
     * @param car
     */
    public static void collide(final Car car){
        System.out.println("my car is colliding:"+car);
    }

    /**
     * 我车被跟踪
     * @param athorCar
     */
    public void follow (final Car athorCar){
        System.out.println("my car is following："+athorCar);
    }

    /**
     * 我的车在修理
     */
    public void repair(){
        System.out.println("my car is repairing!");
    }

}
