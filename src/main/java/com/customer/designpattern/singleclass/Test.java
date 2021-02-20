package com.customer.designpattern.singleclass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    /**
     * 如果我们的对象是通过反射方法invoke出来，这样新建的对象与通过调用getInstance新建的对象是不
     * 一样的，具体咱来看代码
     */
    public  static void testInvoke() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        A a=A.getInstance();
        A a1=A.getInstance();
        System.out.println("a的hash："+a.hashCode()+",b的hash："+a1.hashCode());
        Constructor<A> constructor=A.class.getDeclaredConstructor();
        /**
         * 设置允许修改
         */
        constructor.setAccessible(true);

        A a2=constructor.newInstance();
        System.out.println("a的hash："+a.hashCode()+",c的hash："+a2.hashCode());
        /**
         * 我们可以看到a2的hashcode是和a,a1不一样，因为a2是通过构造器反射出来的，由此可以证明私有构造器
         * 所组成的单例模式并不是十分安全的
         */
    }

    /**
     * 序列化单例测试
     * 简单来说，任何一个readObject方法，不管是显式的还是默认的，它都会返回一
     * 个新建的实例，这个新建的实例不同于该类初始化时创建的实例。
     */
    public  static void serializableMethod() throws IOException, ClassNotFoundException {
        A2 a=A2.getInstance();
        //写
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("hello world"));
        oos.writeObject(a);
        oos.flush();
        oos.close();
        //读
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("hello world"));
        A2 a1 =(A2) ois.readObject();
        ois.close();
        System.out.printf(a+"\n"+a1+"\n");
        System.out.printf("序列化前后两个实例是否是同一个："+(a==a1)+"\n");
    }



    public static void main(String[] args) {

        try {
            /**
             * 反射获取实例测试
             */
            testInvoke();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            /**
             * 序列化测试
             */
            serializableMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            /**
             * 枚举方式测试
             */
            System.out.println("测试enum*********");
            enumMethod();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            /**
             * 枚举类单例序列化测试
             */
            serializableEnumMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void enumMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumA enumA=EnumA.a;
        EnumA enumA1=EnumA.a;
        System.out.println("正常情况下，实例化两个实例是否相同：" + (enumA == enumA1));
        /**
         * 使用构造函数反射验证是否是线程安全及同一个实例的
         */
        Constructor<EnumA> constructor=null;
        /**
         * 第一种构造函数方式： constructor=EnumA.class.getDeclaredConstructor();
         *  异常如下：
         * java.lang.NoSuchMethodException: com.customer.designpattern.singleclass.EnumA.<init>()
         * 	at java.lang.Class.getConstructor0(Class.java:3082)
         * 	原因：Enum类的构造函数：    protected Enum(String name, int ordinal) 有两个参数一个是String  一个是int
         */
        /**
         * 第一种构造函数方式：   constructor=EnumA.class.getDeclaredConstructor(String.class,int.class);
         *  在调用newInstance()函数时，异常如下：
         * java.lang.IllegalArgumentException: Cannot reflectively create enum objects
         * 	at java.lang.reflect.Constructor.newInstance(Constructor.java:416)
         * 	原因：跟下源码发现，jdk已经明确写明了如果是枚举类型，直接抛出异常，所以是无法使用
         * 反射来操作枚举类型的数据的
         */
        constructor.setAccessible(true);
        EnumA enumA2=null;
        enumA2=constructor.newInstance();
        System.out.println("enumA的hash:" + enumA.hashCode() + ",enumA1的hash:" + enumA1.hashCode() + ",enumA2的hash:" + enumA2.hashCode());
        System.out.println("通过反射攻击单例模式情况下，实例化两个实例是否相同：" + (enumA == enumA2));
    }

    /**
     * 枚举类序列化测试
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public  static void serializableEnumMethod() throws IOException, ClassNotFoundException {
        EnumA enumA=EnumA.a;
        //写
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("hello world"));
        oos.writeObject(enumA);
        oos.flush();
        oos.close();
        //读
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("hello world"));
        EnumA enumA1 =(EnumA) ois.readObject();
        ois.close();
        System.out.printf("枚举序列化测试："+enumA+"\n"+enumA1);
        System.out.printf("枚举序列化测试，前后两个实例是否是同一个："+(enumA==enumA1)+"\n");
    }
}
