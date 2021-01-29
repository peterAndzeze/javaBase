package com.customer.interfaceFunction;

import com.customer.functionInterface.InterFaceFunction;
import com.customer.functionInterface.InterFaceFunctionImpl;
import com.customer.functionInterface.InterfaceFunctionFactory;
import org.junit.Test;

public class InterfaceFunctionTest {
    @Test
    public void executeDefaultMethod(){
        InterFaceFunction interFaceFunction= InterfaceFunctionFactory.createInterfaceFunction(InterFaceFunctionImpl::new);
        interFaceFunction.method();
        interFaceFunction.defaultMethod();
    }

}
