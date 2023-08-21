package com.zcct.security.demo.exception;

import com.zcct.common.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/31 19:31
 */
@ControllerAdvice
@Slf4j
public class RequestExceptionHandler {

    @ExceptionHandler(value = BadRequestException.class)
    @ResponseBody
    public R<Object> badRequestException(BadRequestException e, HttpServletRequest request) {
        log.error("请求地址'{}',发生系统异常.", request.getRequestURI(), e);
        return buildErrorResponse(e);
    }

    R<Object> buildErrorResponse(BadRequestException e) {
        return R.fail(e.getStatus(),e.getMessage());
    }
}
