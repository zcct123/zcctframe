package com.zcct.db.annotation;

import java.lang.annotation.*;

/**
 * @author 赵冲
 * @description
 * @date 2023/3/1
 */
@Inherited
@Documented
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value() default "";
}
