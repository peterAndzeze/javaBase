package com.customer.methoduse;

import com.customer.methoduse.Car;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MethodUseTest {
    /**
     * 构造函数测试
     */
    @Test
    public void constructor(){
        /*
         *第一种方法引用的类型是构造器引用，语法是Class::new
         *或者更一般的形式：Class<T>::new。注意：这个构造器没有参数。
         */
        Car car =Car.create(Car::new);
        List<Car> cars= Arrays.asList(car);
        System.out.println(cars.size());
        /*
         *第二种方法引用的类型是静态方法引用，语法是Class::static_method。
         * 注意：这个方法接受一个Car类型的参数。
         */
        cars.forEach(Car::collide);
        /**
         * 第三种方法引用的类型是某个类的成员方法的引用，
         * 语法是Class::method，注意，这个方法没有定义入参：
         */
        cars.forEach(Car::repair);
        /**
         * 第四种方法引用的类型是某个实例对象的成员方法的引用，
         * 语法是instance::method。注意：这个方法接受一个Car类型的参数：
         */
        cars.forEach(car::follow);


    }
}