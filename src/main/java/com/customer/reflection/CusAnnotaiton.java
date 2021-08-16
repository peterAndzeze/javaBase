package com.customer.reflection;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: CusAnnotaiton
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/7/12
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CusAnnotaiton {
   public String name()  default "";
}
