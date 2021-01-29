package com.customer.annotationrepeation;

import com.customer.annotationRepeat.AnnotationRepeation;
import org.junit.Test;

public class AnnotationRepeationTest {
    @Test
    public void annotationRepeat(){
        for (AnnotationRepeation.CustomerAnnotation customerAnnotation: AnnotationRepeation.CustomerAnnotationAble.class.getDeclaredAnnotationsByType(AnnotationRepeation.CustomerAnnotation.class)){
            System.out.println(customerAnnotation.value());
        }

    }
}
