package com.customer.designpattern.nullproject;

/**
 * 创建类工厂
 */
public class CustomerFactory {
    /**
     * 定义名称集合
     */
    public static final String [] names={"Rob","Joe","Julie"};

    /**
     * 返回对象实例
     * @param name
     * @return
     */
    public static AbstractCustomer getCustomer(String name){
        for (int i = 0; i <names.length ; i++) {
            if(names[i].equalsIgnoreCase(name)){
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
