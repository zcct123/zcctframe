package com.zcct.security.demo.security.aspect;

import cn.hutool.core.util.ObjectUtil;
import com.zcct.security.demo.security.annotation.RequireAnonymous;
import com.zcct.security.demo.security.annotation.RequireRules;
import com.zcct.security.demo.security.annotation.RequiresLogin;
import com.zcct.security.demo.security.annotation.RequiresPermissions;
import com.zcct.security.demo.util.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author zcct
 * @version 1.0
 * @description: @RequireRules @RequiresLogin @RequiresPermissions 请求拦截验证
 * @date 2022/9/3 17:12
 */
@Aspect
@Component
public class AuthorizeAspect {

    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.zcct.security.demo.security.annotation.RequireRules) " +
            "|| @annotation(com.zcct.security.demo.security.annotation.RequiresLogin) " +
            "|| @annotation(com.zcct.security.demo.security.annotation.RequiresPermissions) " +
            "|| @annotation(com.zcct.security.demo.security.annotation.RequireAnonymous)")
    public void pointcut() {
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {


        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        authorize(method);

        Object obj = joinPoint.proceed();
        return obj;
    }

    private void authorize(Method method) {
        RequireRules requireRules = method.getAnnotation(RequireRules.class);
        if(ObjectUtil.isNotEmpty(requireRules)) {
            SecurityUtils.checkRules(requireRules.value());
        }
        RequiresLogin requiresLogin = method.getAnnotation(RequiresLogin.class);
        if(ObjectUtil.isNotEmpty(requiresLogin)) {
            SecurityUtils.checkLogin();
        }
        RequiresPermissions requiresPermissions = method.getAnnotation(RequiresPermissions.class);
        if(ObjectUtil.isNotEmpty(requiresPermissions)) {
            SecurityUtils.checkPermissions(requiresPermissions.value());
        }
        RequireAnonymous requireAnonymous = method.getAnnotation(RequireAnonymous.class);
        if(ObjectUtil.isNotEmpty(requireAnonymous)) {
            SecurityUtils.checkAnonymous();
        }
    }
}
