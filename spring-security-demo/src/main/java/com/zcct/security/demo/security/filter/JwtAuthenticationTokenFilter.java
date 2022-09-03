package com.zcct.security.demo.security.filter;

import cn.hutool.core.util.StrUtil;
import com.zcct.security.demo.exception.BadRequestException;
import com.zcct.security.demo.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zcct
 * @version 1.0
 * @description:  获取请求头 token 解析token 在 redis 中获取用户信息
 *               要放在 验证过滤器之前
 * @date 2022/9/2 20:08
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if(StrUtil.isNotBlank(token)) {
            try{
                jwtTokenProvider.parseJwt(token);
            }catch (Exception e) {
                e.printStackTrace();
                log.debug("非法Token：{}", token);
            }
        }
        filterChain.doFilter(request,response);
    }
}
