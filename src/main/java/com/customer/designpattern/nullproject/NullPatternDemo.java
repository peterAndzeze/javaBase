package com.customer.designpattern.nullproject;

/**
 * 测试类
 *
 * 空对象就是一个正常的对象，只不过你用这个对象来替代null。作用就是 当使用null表示缺少对象
 * 时，在每次引用前都要测试其是否为null，因此需要在代码中加入判断语句，当判断语句变多时，代码
 * 就变得杂乱，使用空对象可以减少判断的语句
 */
public class NullPatternDemo {
    public static void main(String[] args) {
        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");
        System.out.println("Customers");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }
}
