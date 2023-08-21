package com.zcct.common.domain;

import java.io.Serializable;

/**
 * @author zcct
 * @version 1.0
 * @description: 接收消息
 * @date 2022/8/27 22:21
 */

public class R<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;

    private Long timestamp;

    private R(T data, int code, String msg , Long timestamp) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
