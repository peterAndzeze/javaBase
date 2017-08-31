package com.customer.listNew;

import org.junit.Before;
import org.junit.Test;

public class LambdaNewTest {
    private LambdaNew lambdaNew;
    @Before
    public void init(){
        lambdaNew=new LambdaNew();
    }
    @Test
    public void lambadTest(){

        lambdaNew.lambdaList();
    }
    @Test
    public void lambdaUseProperty(){
        lambdaNew.lambdaUseProperty();
    }
    @Test
    public void lambdaReturnValue(){
        lambdaNew.lambdaReturnValue();
    }
    @Test
    public void listSort(){
        lambdaNew.listSort();
    }
    @Test
    public void mapTest(){
        lambdaNew.map();
    }

}
