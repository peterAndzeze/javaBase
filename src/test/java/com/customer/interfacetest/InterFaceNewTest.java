package com.customer.interfacetest;

import com.customer.interfaceNew.InterfaceNew;
import com.customer.interfaceNew.InterfaceNewImpl;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InterFaceNewTest {

    @Test
    public void oldInterfaceMethod(){
        InterfaceNew interfaceNew=new InterfaceNewImpl();
        interfaceNew.say("hello word");
        interfaceNew.eat("菠萝");

    }
    @Test
    public  void removeMap(){
        Map<String,String> maps=new ConcurrentHashMap<>();
        maps.put("key","11");
        String value=maps.remove("key");
        System.out.println(value);
    }

}
