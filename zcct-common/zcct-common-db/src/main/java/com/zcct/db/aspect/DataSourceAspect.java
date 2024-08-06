package com.zcct.db.aspect;

import com.zcct.db.DynamicDataSourceContextHolder;
import com.zcct.db.annotation.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import java.util.Objects;

/**
 * @author 赵冲
 * @description
 * @date 2023/3/1
 */
@Aspect
@Component
@Order(-1)
public class DataSourceAspect {

    @Pointcut("@annotation(com.zcct.db.annotation.DataSource)"
            + "|| @within(com.zcct.db.annotation.DataSource)")
    public void dsPc() {

    }

    @Around("dsPc()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        DataSource ds = getDataSource(point);

        if (Objects.nonNull(ds)) {
            DynamicDataSourceContextHolder.push(ds.value());
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSourceContextHolder.poll();
        }
    }

    /**
     * 获取需要切换的数据源
     */
    public DataSource getDataSource(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataSource dataSource = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);
        if (Objects.nonNull(dataSource)) {
            return dataSource;
        }
        return AnnotationUtils.findAnnotation(signature.getDeclaringType(), DataSource.class);
    }
}
