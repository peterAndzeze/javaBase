package com.customer.designpattern.proxy.transaction;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 */
public class ProxyFactory {
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 使用jdk 动态代理
     * @param obj 委托对象
     * @return 代理对象
     */
    public Object getJdkProxy(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result=null;
                try {
                    //开启事务操作
                    transactionManager.beginTransaction();
                    System.out.println("method："+method);
                    //执行事务操作
                    result = method.invoke(obj, args);
                    //提交事务
                    transactionManager.commitTransaction();

                }catch (Exception e){
                    transactionManager.rollbackTransaction();
                    throw e;
                }
                return result;
            }
        });
    }

    /**
     * Cglib 生成代理对象
     * @param obj 委托对象
     * @return 代理
     */
    public Object  getCglibProxy(Object obj){
        return Enhancer.create(obj.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result=null;
                try {
                    //开启事务操作
                    transactionManager.beginTransaction();
                    //执行事务操作
                    result = method.invoke(obj, objects);
                    transactionManager.commitTransaction();

                }catch (Exception e){
                    transactionManager.rollbackTransaction();
                    throw e;
                }
                return result;
            }
        });
    }

}
