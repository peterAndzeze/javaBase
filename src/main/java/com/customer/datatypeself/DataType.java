package com.customer.datatypeself;

import java.util.function.Supplier;

/**
 * 很多场景下编译器可以推导出某个参数的数据类型
 * @param <T>
 */
public class DataType<T> {
    public String defaultValue(){
        return "defaultValue";
    }

    public T getValue(T value,T defauleValue){
        return  value==null?defauleValue :value;
    }



}
