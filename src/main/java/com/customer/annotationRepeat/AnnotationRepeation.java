package com.customer.annotationRepeat;

import java.lang.annotation.*;

/**
 * 在同一个地方不能多次使用同一个注解。
 * jdk1.8中引入了重复注解的概念，允许在同一个地方多次使用同一个注解。
 *在Java 8中使用@Repeatable注解定义重复注解，实际上，这并不是语言层面的改进，
 *而是编译器做的一个trick，底层的技术仍然相同
 */
public class AnnotationRepeation {

    @Target( ElementType.TYPE )
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CustomerAnnotations{
        CustomerAnnotation[] value();
    }
    @Target( ElementType.TYPE )
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(CustomerAnnotations.class)
    public  @interface  CustomerAnnotation{
        String value();
    }
    @CustomerAnnotation("CustomerAnnotation1")
    @CustomerAnnotation("CustomerAnnotation2")
    public interface  CustomerAnnotationAble{

    }

}
