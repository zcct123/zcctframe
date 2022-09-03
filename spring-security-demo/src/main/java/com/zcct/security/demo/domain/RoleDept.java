package com.zcct.security.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 角色和部门关联表
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@Getter
@Setter
@TableName("sys_role_dept")
@ApiModel(value = "RoleDept对象", description = "角色和部门关联表")
public class RoleDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色ID")
    @TableField(value = "role_id")
    private Long roleId;

    @ApiModelProperty("部门ID")
    @TableField(value = "dept_id")
    private Long deptId;
}
