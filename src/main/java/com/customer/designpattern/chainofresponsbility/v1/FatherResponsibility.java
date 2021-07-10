package com.customer.designpattern.chainofresponsbility.v1;

/**
 * 爸爸责任
 */
public class FatherResponsibility implements ChildSchoolResponsibility {
    @Override
    public boolean doCheck(Child child) {
        if(null==child.getSecurityPhone()){
            return false;
        }
        System.out.println("爸爸检查安全电话没有问题");
        return true;
    }
}
