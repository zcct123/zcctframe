package com.zcct.common.web.log.aspect;

import com.alibaba.fastjson.JSON;
import com.zcct.common.web.log.annotation.Log;
import com.zcct.common.web.utils.IpUtils;
import com.zcct.service.user.api.dto.LogDto;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        handlelogAround(joinPoint,result);

        return result;
    }

    /**
     * 配置异常通知
     * @param e exception
     */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        handlelogAfterThrowing(joinPoint, e);
    }

    private void handlelogAfterThrowing(JoinPoint joinPoint, Throwable e) {
        LogDto logDto = setBaseInfo(joinPoint);
        logDto.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));

//        iLogService.saveLog(logDto);
    }

    private void handlelogAround(ProceedingJoinPoint joinPoint, Object result) {
        LogDto logDto = setBaseInfo(joinPoint);
        logDto.setResult(StringUtils.substring(JSON.toJSONString(result), 0, 2000));
//        iLogService.saveLog(logDto);
    }

    private LogDto setBaseInfo(JoinPoint joinPoint) {
        HttpServletRequest servletRequest = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        LogDto logDto = new LogDto();
        logDto.setOperTime(new Timestamp(System.currentTimeMillis()));
        logDto.setTime(System.currentTimeMillis() - TIME_THREADLOCAL.get());
        TIME_THREADLOCAL.remove();
        logDto.setRequestIp(IpUtils.getIpAddr(servletRequest));
        logDto.setRequestUrl(StringUtils.substring(servletRequest.getRequestURI(), 0, 255));
        logDto.setRequestMethod(servletRequest.getMethod());

        //todo 设置用户名
        logDto.setUsername("todo");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log log = method.getAnnotation(Log.class);
        logDto.setTitle(log.value().toString());
        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName() + "." + signature.getName() + "()";
        logDto.setMethod(methodName);


        StringBuilder params = new StringBuilder("{");
        //参数值
        List<Object> argValues = new ArrayList<>(Arrays.asList(joinPoint.getArgs()));
        //参数名称
        for (Object argValue : argValues) {
            params.append(argValue).append(" ");
        }

        return logDto;
    }


}
