package com.customer.array;

import org.junit.Before;
import org.junit.Test;

public class ParallelArrayTest {
    private ParallelArray parallelArray;
    @Before
    public  void init (){
        parallelArray=new ParallelArray();
    }
    @Test
    public void sortArr(){
        parallelArray.parallelArray();
    }
}
