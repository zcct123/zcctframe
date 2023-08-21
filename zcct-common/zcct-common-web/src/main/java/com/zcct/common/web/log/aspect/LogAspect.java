package com.zcct.common.web.log.aspect;

import com.zcct.common.web.log.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.http.HttpMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 15:13
 * @description:
 */
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>();


    @Pointcut("@annotation(com.zcct.common.web.log.annotation.Log)")
    public void pointcut() {}

    /**
     * 处理请求前执行
     */
    @Before(value = "@annotation(Log)")
    public void boBefore(JoinPoint joinPoint) {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    /**
     * 配置环绕通知
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        TIME_THREADLOCAL.set(System.currentTimeMillis());
        result = joinPoint.proceed();
        handleArointLog();

        return result;
    }

    /**
     * 配置异常通知
     * @param e exception
     */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        handlelogAfterThrowing();
    }

    private void handlelogAfterThrowing() {
    }

    private void handleArointLog() {
    }
}
