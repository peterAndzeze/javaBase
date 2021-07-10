package com.customer.designpattern.chainofresponsbility.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * 孩子上学
 */
public class ChildGoSchoolChain {
    private List<ChildSchoolResponsibility> schoolResponsibilities=new ArrayList<>();
    private int index=0;
    private boolean chainFlag=true;


    public ChildGoSchoolChain addChains(ChildSchoolResponsibility childSchoolResponsibility){
        schoolResponsibilities.add(childSchoolResponsibility);
        return this;
    }

    public void doCheck(Child child,ChildGoSchoolChain childGoSchoolChain){

       /* for (ChildSchoolResponsibility childSchoolResponsibility:schoolResponsibilities){
            if(!childSchoolResponsibility.doCheck(child)){
                System.out.println(childSchoolResponsibility.getClass().getName()+"检查不通过不能上学");
            }
        }
        child.goSchool();*/

       if(index==schoolResponsibilities.size()){
           return;
       }
       ChildSchoolResponsibility childSchoolResponsibility=schoolResponsibilities.get(index);
       index++;
        System.out.println(childSchoolResponsibility.getClass().getSimpleName());

        if(! childSchoolResponsibility.doCheck(child,childGoSchoolChain)){
            chainFlag=false;
           return ;
       }


    }

    public boolean isChainFlag() {
        return chainFlag;
    }

    public void setChainFlag(boolean chainFlag) {
        this.chainFlag = chainFlag;
    }
}
