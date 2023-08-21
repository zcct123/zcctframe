package com.zcct.security.demo.security.rest;

import com.zcct.security.demo.security.entity.LoginUser;
import com.zcct.security.demo.security.service.UserLoginService;
import com.zcct.common.domain.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/30 21:44
 */
@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Api(tags = "系统：系统授权接口")
public class AuthorizationController {

    private final UserLoginService userLoginService;

    @ApiOperation("登录授权")
    @PostMapping(value = "/login")
    public R<Object> login(@Validated @RequestBody LoginUser loginUser, HttpServletRequest request) throws Exception {
        return R.ok(userLoginService.login(loginUser));
    }

    @ApiOperation("获取用户信息")
    @GetMapping(value = "/getInfo")
    public R<Object> getInfo() throws Exception {
        return R.ok(userLoginService.getInfo());
    }

    @ApiOperation("推出登录")
    @PostMapping(value = "/logout")
    public R<Object> logout() throws Exception {
        userLoginService.logout();
        return R.ok("退出登录成功");
    }
}
