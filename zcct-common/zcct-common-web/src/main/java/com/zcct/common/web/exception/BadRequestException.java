package com.zcct.common.web.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 10:18
 * @description:
 */
public class BadRequestException extends RuntimeException{

    private Integer status = BAD_REQUEST.value();

    public BadRequestException(String msg){
        super(msg);
    }

    public BadRequestException(HttpStatus status, String msg){
        super(msg);
        this.status = status.value();
    }
}
