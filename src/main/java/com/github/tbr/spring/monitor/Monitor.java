package com.github.tbr.spring.monitor;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Monitor {
    String name() default "";
}
