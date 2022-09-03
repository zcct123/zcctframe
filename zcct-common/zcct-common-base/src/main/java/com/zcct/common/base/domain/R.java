package com.zcct.common.base.domain;

import com.zcct.common.base.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/27 22:21
 */
@Data
public class R<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;

    private R(T data, int code, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    private R(ResultCode resultCode) {
        this(resultCode, resultCode.getMessage());
    }

    private R(ResultCode resultCode, String msg) {
        this(resultCode,  null , msg);
    }

    private R(ResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMessage());
    }

    private R(ResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private R(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> R<T> ok(T data)
    {
        return new R(ResultCode.SUCCESS,data);
    }

    public static <T> R<T> ok(T data, String msg)
    {
        return new R(ResultCode.SUCCESS,data, msg);
    }

    public static <T> R<T> fail()
    {
        return new R(ResultCode.FAILURE);
    }

    public static <T> R<T> fail(String msg)
    {
        return new R(ResultCode.FAILURE,msg);
    }

    public static <T> R<T> fail(T data)
    {
        return new R(ResultCode.FAILURE,data);
    }

    public static <T> R<T> fail(T data, String msg)
    {
        return new R(ResultCode.FAILURE,data,msg);
    }

    public static <T> R<T> fail(int code, String msg)
    {
        return new R<>(code,null,msg);
    }



}
