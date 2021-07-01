package com.customer.designpattern.strategy.strageimpl;


public class BasketballAgeComparator implements CusComparator<BasketballPerson> {
    @Override
    public int compareTo(BasketballPerson o1, BasketballPerson o2) {
        if(o1.age<o2.age) return -1;
        if (o1.age>o2.age) return 1;
        return 0;
    }
}
