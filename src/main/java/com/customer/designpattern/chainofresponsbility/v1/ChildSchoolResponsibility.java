package com.customer.designpattern.chainofresponsbility.v1;

/**
 * 上学要做的事
 */
public interface ChildSchoolResponsibility {
    /**
     * 上学前检查
     * @param child
     * @return
     */
    boolean doCheck(Child child);

}
