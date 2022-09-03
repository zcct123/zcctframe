package com.zcct.security.demo.security.annotation;


import java.lang.annotation.*;

/**
 * 只允许匿名访问的接口
 */

@Documented
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireAnonymous {
}
