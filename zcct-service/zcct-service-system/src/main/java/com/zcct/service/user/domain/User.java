package com.zcct.service.user.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Getter
@Setter
@TableName("sys_user")
@ApiModel(value = "User对象", description = "用户信息表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty("部门ID")
    @TableField("dept_id")
    private Long deptId;

    @ApiModelProperty("租户ID")
    @TableField("tenant_id")
    private Long tenantId;

    @ApiModelProperty("用户账号")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("用户昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty("用户类型（0管理员用户, 01系统用户 ）")
    @TableField("user_type")
    private Integer userType;

    @ApiModelProperty("用户邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("手机号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("用户性别（0男 1女 2未知）")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty("头像地址")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("帐号状态（0正常 1停用）")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("最后登录IP")
    @TableField("login_ip")
    private String loginIp;

    @ApiModelProperty("最后登录时间")
    @TableField("login_date")
    private Timestamp loginDate;

    @ApiModelProperty("创建者")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    @ApiModelProperty("更新者")
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;

    @ApiModelProperty("删除标志")
    @TableField("is_deleted")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;
}
