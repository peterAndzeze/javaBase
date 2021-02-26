package com.customer.thread.queue.impl;

import java.util.AbstractQueue;
import java.util.Iterator;

public class CustomerArrayBlockingQueue extends AbstractQueue {
    /**
     * 数组实现的阻塞队列 在构造函数的地方，需要传入数组的容量
     */

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    /**
     * put() 当队列满的时候 阻塞
     * take() 当队列为空的时候 阻塞
     */
}
