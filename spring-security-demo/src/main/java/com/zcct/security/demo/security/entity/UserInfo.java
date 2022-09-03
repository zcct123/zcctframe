package com.zcct.security.demo.security.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zcct.security.demo.domain.Role;
import com.zcct.security.demo.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author zcct
 * @version 1.0
 * @description: 当前登录用户信息
 * @date 2022/9/3 16:19
 */
@Data
@AllArgsConstructor
public class UserInfo {

    @ApiModelProperty("角色列表")
    private Set<Role> roles;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("头像地址")
    private String avatar;

}
