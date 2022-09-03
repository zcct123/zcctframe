package com.zcct.security.demo.security.entity;

import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/31 21:44
 */
@Data
public class LoginUser {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
