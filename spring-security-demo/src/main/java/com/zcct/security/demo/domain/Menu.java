package com.zcct.security.demo.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author zcct
 * @since 2022-08-31
 */
@Getter
@Setter
@TableName("sys_menu")
@ApiModel(value = "Menu对象", description = "菜单权限表")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单ID")
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    @ApiModelProperty("菜单名称")
    @TableField("menu_name")
    private String menuName;

    @ApiModelProperty("父菜单ID")
    @TableField("pid")
    private Long pid;

    @ApiModelProperty("排序")
    @TableField("menu_sort")
    private Integer menuSort;

    @ApiModelProperty("路由地址")
    @TableField("path")
    private String path;

    @ApiModelProperty("组件路径")
    @TableField("component")
    private String component;

    @ApiModelProperty("路由参数")
    @TableField("query")
    private String query;

    @ApiModelProperty("是否为外链（0是 1否）")
    @TableField("is_frame")
    private Integer frame;

    @ApiModelProperty("是否缓存（0缓存 1不缓存）")
    @TableField("is_cache")
    private Integer cache;

    @ApiModelProperty("菜单类型（M目录 C菜单 F按钮）")
    @TableField("menu_type")
    private Integer menuType;

    @ApiModelProperty("菜单状态（0显示 1隐藏）")
    @TableField("visible")
    private Integer visible;

    @ApiModelProperty("菜单状态（0正常 1停用）")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("权限")
    @TableField("permission")
    private String permission;

    @ApiModelProperty("菜单图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("创建者")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty("更新者")
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @ApiModelProperty("创建日期")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;
}
