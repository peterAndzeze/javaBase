package com.customer.functionInterface;

import java.util.function.Supplier;

public  interface InterfaceFunctionFactory {
    /**
     * 返回实现
     * @param supplier
     * @return
     */
     static InterFaceFunction createInterfaceFunction(Supplier<InterFaceFunction> supplier){
        return supplier.get();
    }
}
