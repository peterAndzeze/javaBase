package com.customer.designpattern.chainofresponsbility.v1;

/**
 * 妈妈责任
 */
public class MotherResponsibility implements ChildSchoolResponsibility {
    @Override
    public boolean doCheck(Child child) {
        if(null==child.getClothes()){
            return false;
        }
        System.out.println("妈妈检查衣服没有问题");
        return true;
    }
}
