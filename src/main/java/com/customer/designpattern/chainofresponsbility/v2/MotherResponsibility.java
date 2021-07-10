package com.customer.designpattern.chainofresponsbility.v2;

/**
 * 妈妈责任
 */
public class MotherResponsibility implements ChildSchoolResponsibility {
    @Override
    public boolean doCheck(Child child,ChildGoSchoolChain childGoSchoolChain) {
        if(null==child.getClothes()){
            return false;
        }
        System.out.println("妈妈检查衣服没有问题");
        childGoSchoolChain.doCheck(child, childGoSchoolChain);
        return true;
    }
}
