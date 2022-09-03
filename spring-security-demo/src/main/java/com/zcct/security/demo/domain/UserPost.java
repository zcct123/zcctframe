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
 * 用户与岗位关联表
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@Getter
@Setter
@TableName("sys_user_post")
@ApiModel(value = "UserPost对象", description = "用户与岗位关联表")
public class UserPost implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    @TableField(value = "user_id")

    private Long userId;

    @ApiModelProperty("岗位ID")
    @TableField(value = "post_id")
    private Long postId;
}
