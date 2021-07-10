package com.customer.designpattern.chainofresponsbility.v1;

/**
 * 小孩
 */
public class Child {
    /**
     * 衣服
     */
    public String clothes;
    /**
     * 安全电话
     */
    public String securityPhone;

    private String name;

    public Child( String name) {
        this.name = name;
    }

    /**
     * 要干的事情
     */
    public void goSchool(){
        System.out.println(this.name+"可以去上学了");
    }

    public String getClothes() {
        return clothes;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public String getSecurityPhone() {
        return securityPhone;
    }

    public void setSecurityPhone(String securityPhone) {
        this.securityPhone = securityPhone;
    }
}
