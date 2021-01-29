package com.customer.nullvalidate;

import org.junit.Test;

public class NullExceptionTest {
    @Test
    public void nullValidate(){
        NullException nullException=new NullException();
        nullException.validateNull();
    }
}
