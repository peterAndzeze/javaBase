package com.customer.datatypeself;

import org.junit.Test;

import java.util.function.Supplier;

public class DataTypeSelfTest {
    /**
     * 更好的数据类型推断
     */
    @Test
    public void dataTypeSelf(){
        DataType<String> dataType= new DataType<>();
       String value= dataType.getValue("zhangsan",dataType.defaultValue());
        System.out.println(value);


        DataType<Long> dataType1= new DataType<>();
        String value1= dataType.getValue("2",dataType.defaultValue());
        System.out.println(value1);

    }
}
