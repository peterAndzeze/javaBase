package com.customer.designpattern.chainofresponsbility.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * 孩子上学
 */
public class ChildGoSchoolChain {
    private List<ChildSchoolResponsibility> schoolResponsibilities=new ArrayList<>();
    private int index=0;


    public ChildGoSchoolChain addChains(ChildSchoolResponsibility childSchoolResponsibility){
        schoolResponsibilities.add(childSchoolResponsibility);
        return this;
    }

    public boolean doCheck(Child child){

       /* for (ChildSchoolResponsibility childSchoolResponsibility:schoolResponsibilities){
            if(!childSchoolResponsibility.doCheck(child)){
                System.out.println(childSchoolResponsibility.getClass().getName()+"检查不通过不能上学");
            }
        }
        child.goSchool();*/

       if(index==schoolResponsibilities.size()){
           return false;
       }
       ChildSchoolResponsibility childSchoolResponsibility=schoolResponsibilities.get(index);
       index++;
       return childSchoolResponsibility.doCheck(child);
    }


}
