package com.customer.nashornjs;

import org.junit.Before;
import org.junit.Test;

public class JsNashornTest {
    private JsNashorn jsNashorn;
    @Before
    public  void init(){
        jsNashorn=new JsNashorn();
    }
    @Test
    public void jsFunctionTest(){
        jsNashorn.executorJsFunction();
    }
}

