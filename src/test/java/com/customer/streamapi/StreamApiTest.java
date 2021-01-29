package com.customer.streamapi;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamApiTest {
    private StreamApi streamApi;
    @Before
    public void befrore(){
        streamApi=new StreamApi();
    }
    @Test
    public void testStream(){
        Long count=streamApi.totalOpentasks;
        System.out.println("打开的数据：××××"+count);
        Long skip=streamApi.skip;
        System.out.println("打开的数据：××××"+skip);
        Long numberCount=streamApi.numberCount;
        System.out.println(numberCount);
        streamApi.operationPoints();
        streamApi.filterNumbers();
    }
    @Test
    public void repeatNumbers(){
        streamApi.getMaxOrMinNumber();
    }

}


