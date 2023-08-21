package com.zcct.security.demo.security.rest;

import com.zcct.security.demo.security.annotation.RequireAnonymous;
import com.zcct.security.demo.security.annotation.RequireRules;
import com.zcct.security.demo.security.annotation.RequiresLogin;
import com.zcct.security.demo.security.annotation.RequiresPermissions;
import com.zcct.common.domain.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcct
 * @version 1.0
 * @description: 测试授权相关注解
 * @date 2022/9/3 18:54
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/login")
    @RequiresLogin
    public R<Object> login() throws Exception {
        return R.ok("访问成功");
    }

    @GetMapping(value = "/rules")
    @RequireRules("admin")
    public R<Object> rules() throws Exception {
        return R.ok("访问成功");
    }

    @GetMapping(value = "/permissions")
    @RequiresPermissions("user:list")
    public R<Object> permissions() throws Exception {
        return R.ok("访问成功");
    }

    @GetMapping(value = "/anonymous")
    @RequireAnonymous
    public R<Object> anonymous() throws Exception {
        return R.ok("访问成功");
    }
}
