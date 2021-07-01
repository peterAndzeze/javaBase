package com.customer.designpattern.strategy;

import com.customer.designpattern.strategy.strageimpl.BasketballAgeComparator;
import com.customer.designpattern.strategy.strageimpl.BasketballPerson;
import com.customer.designpattern.strategy.strageimpl.SorterComparator;

import java.util.Arrays;

/**
 * 策略模式测试
 */
public class strategyClient {

    public static void main(String[] args) {
        /*int [] arr={3,1,4,6,5,8,2};
        Sorter.sort(arr);
        System.out.println(Arrays.toString(arr));*/
       /* Dog [] dogs={new Dog(1),new Dog(5),new Dog(3),new Dog(4)};
        SorterObject.sort(dogs);*/
        BasketballPerson [] a={new BasketballPerson(10),new BasketballPerson(8),new BasketballPerson(12)};

        SorterComparator<BasketballPerson> sorterComparator = new SorterComparator<>();
        sorterComparator.sort(a,new BasketballAgeComparator());


        System.out.println(Arrays.toString(a));


    }

}
