package com.annotation.example.demo.annotate;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    String value() default "";
}
