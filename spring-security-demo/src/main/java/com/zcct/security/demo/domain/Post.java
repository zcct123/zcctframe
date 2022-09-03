package com.zcct.security.demo.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 岗位信息表
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@Getter
@Setter
@TableName("sys_post")
@ApiModel(value = "Post对象", description = "岗位信息表")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("岗位ID")
    @TableId(value = "post_id", type = IdType.AUTO)
    private Long postId;

    @ApiModelProperty("租户ID")
    @TableField("tenant_id")
    private Long tenantId;

    @ApiModelProperty("岗位编码")
    @TableField("post_code")
    private String postCode;

    @ApiModelProperty("岗位名称")
    @TableField("post_name")
    private String postName;

    @ApiModelProperty("显示顺序")
    @TableField("post_sort")
    private Integer postSort;

    @ApiModelProperty("状态（0正常 1停用）")
    @TableField("status")
    private Integer status;

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
}
