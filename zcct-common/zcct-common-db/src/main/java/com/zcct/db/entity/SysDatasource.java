package com.zcct.db.entity;

import lombok.Data;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2024/8/5 14:41
 * @description:
 */
@Data
public class SysDatasource {

    private long id;

    private String type;
    private String url;
    private String driverClassName;
    private String username;
    private String password;
    private String remark;

}
