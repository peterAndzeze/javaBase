package com.customer.designpattern.chainofresponsbility.v2;

/**
 * 爸爸责任
 */
public class FatherResponsibility implements ChildSchoolResponsibility {
    @Override
    public boolean doCheck(Child child,ChildGoSchoolChain childGoSchoolChain) {
        if(null==child.getSecurityPhone()){
            System.out.println("爸爸没有看到安全电话");
            return false;
        }
        System.out.println("爸爸检查安全电话没有问题");
        childGoSchoolChain.doCheck(child,childGoSchoolChain);
        return  true;
    }
}
