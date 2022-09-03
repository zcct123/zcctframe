package com.zcct.common.base.enums;

/**
 * @author zcct
 * @version 1.0
 * @description: 错误码
 * @date 2022/8/27 22:30
 */
public enum ResultCode {

    SUCCESS(200,"操作成功"),
    FAILURE(400,"业务异常"),
    CREATED(201,"创建成功"),
    ACCEPTED(202,"请求已经被接受"),
    NO_CONTENT(204,"操作已经执行成功，但是没有返回数据"),
    MOVED_PERM(301,"资源已被移除"),
    SEE_OTHER(303,"重定向"),
    NOT_MODIFIED(304,"资源没有被修改"),
    BAD_REQUEST(400,"参数列表错误"),
    UNAUTHORIZED(401,"未授权"),
    FORBIDDEN(403,"授权过期"),
    NOT_FOUND(404,"资源未找到"),
    BAD_METHOD(405,"不允许的方法"),
    UNSUPPORTED_TYPE(415,"不支持的数据，媒体类型"),
    ERROR(500,"系统异常"),
    NOT_IMPLEMENTED(501,"接口未实现");

    final int code;
    final String message;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    private ResultCode(final int code, final String message) {
        this.code = code;
        this.message = message;
    }
}
