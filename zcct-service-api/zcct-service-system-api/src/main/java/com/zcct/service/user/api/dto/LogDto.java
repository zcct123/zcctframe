package com.zcct.service.user.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 14:11
 * @description:
 */
@Getter
@Setter
public class LogDto {

    /** 操作用户 */
    private String username;

    /** 标题 */
    private String title;

    /** 方法名 */
    private String method;

    /** 请求方法 */
    private String requestMethod;

    /** 请求参数 */
    private String param;

    /** 返回参数 */
    private String result;

    /** 日志类型  0 ：成功 1:失败 */
    private Integer type;

    /** 请求ip */
    private String requestIp;

    /** 请求耗时 */
    private Long time;

    /** 操作日期 */
    private Timestamp operTime;

    private String errorMsg;
}
