package com.soft.filter.log;

import java.lang.annotation.*;

/**
 * @Auther: 野性的呼唤
 * @Date: 2020/5/8 18:11
 * @Description:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {

    String description() default "";

}
