package com.zcct.security.demo.security.annotation;

import java.lang.annotation.*;

/**
 * 有登录信息可以访问
 */
@Documented
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresLogin {
}
