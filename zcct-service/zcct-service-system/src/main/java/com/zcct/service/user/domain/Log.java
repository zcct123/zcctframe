package com.zcct.service.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 11:14
 * @description:
 */
@Getter
@Setter
@TableName("sys_log")
@ApiModel(value = "log对象", description = "日志表")
@NoArgsConstructor
public class Log  implements Serializable {

    @TableId(value = "dept_id", type = IdType.AUTO)
    private Long id;

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

