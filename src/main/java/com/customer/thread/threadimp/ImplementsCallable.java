package com.customer.thread.threadimp;

import java.util.concurrent.Callable;

/**
 * 实现CallAble 函数
 * @author sw
 */
public class ImplementsCallable  implements Callable<String> {
    @Override
    public String call() throws Exception {
        String result="implements Callable and get result";
        return result;
    }
}
