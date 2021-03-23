package com.customer.designpattern.proxy.special;

public class SpecialSubject implements SpecialSubjectInterface {
    private SpecialSubjectInterface proxy;
    private String name;

    public SpecialSubject(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        if(this.isProxy()){
            System.out.println(this.proxy+"代理类在执行 吃饭");
        }else {
            System.out.println("未知代理类 不让吃饭");
        }
    }

    @Override
    public void sleep() {
        if(this.isProxy()){
            System.out.println(this.proxy+"代理类在执行 睡觉");
        }else {
            System.out.println("未知代理类 不让睡觉");
        }
    }

    private boolean isProxy(){
        if(this.proxy==null){
            return false;
        }
        return true;
    }

    @Override
    public SpecialSubjectInterface getProxy() {
        this.proxy=new SpecialProxy(this);
        return this.proxy;
    }
}
