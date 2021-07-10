package com.customer.designpattern.chainofresponsbility.v1;

/**
 * 责任链模式客户端
 */
public class ChainClient {
    public static void main(String[] args) {

        Child child=new Child("陈琛");
        child.setClothes("花衣服");
        child.setSecurityPhone("apple phone");
        ChildGoSchoolChain childGoSchoolChain=new ChildGoSchoolChain().addChains(new MotherResponsibility())
                .addChains(new FatherResponsibility());
        childGoSchoolChain.doCheck(child);
    }

}
