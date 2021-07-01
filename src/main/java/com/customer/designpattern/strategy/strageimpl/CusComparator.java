package com.customer.designpattern.strategy.strageimpl;

/**
 * 比较器
 * @param <T>
 */
public interface CusComparator<T> {
    /**
     * 函数比较
     * @param o1
     * @param o2
     * @return
     */
    int compareTo(T o1,T o2);
}
