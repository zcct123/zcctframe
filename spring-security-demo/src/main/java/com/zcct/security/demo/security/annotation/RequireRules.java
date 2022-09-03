package com.zcct.security.demo.security.annotation;

import java.lang.annotation.*;

/**
 * 指定角色可以访问
 */
@Documented
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireRules {
    String[] value() default {};
}
