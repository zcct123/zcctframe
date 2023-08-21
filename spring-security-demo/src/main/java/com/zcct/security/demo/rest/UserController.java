package com.zcct.security.demo.rest;

import com.zcct.security.demo.service.UserService;
import com.zcct.common.domain.R;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public R<Object> queryById(@PathVariable Long id){

        new FilterChainProxy();
        return R.ok( userService.queryById(id));
    }

}
