package com.zcct.security.demo.security;


import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.zcct.common.redis.service.RedisUtil;
import com.zcct.security.demo.security.entity.JwtUser;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/9/2 19:17
 */
@Slf4j
@Component
public class JwtTokenProvider {

    @Resource
    private RedisUtil redisUtil;
    public static final String AUTHORITIES_KEY = "user";
    private JwtParser jwtParser;
    private JwtBuilder jwtBuilder;

    private static String  BASE64_SECRET = "ZmQ0ZGI5NjQ0MDQwY2I4MjMxY2Y3ZmI3MjdhN2ZmMjNhODViOTg1ZGE0NTBjMGM4NDA5NzYxMjdjOWMwYWRmZTBlZjlhNGY3ZTg4Y2U3YTE1ODVkZDU5Y2Y3OGYwZWE1NzUzNWQ2YjFjZDc0NGMxZWU2MmQ3MjY1NzJmNTE0MzI=";

    /**
     * 初始化
     */
    @PostConstruct
    public void init() {
        Key key = generalKey();
        jwtParser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        jwtBuilder = Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS512);
    }

    /**
     * 由字符串生成加密key
     * @return
     */
    public static Key generalKey() {
        byte[] encodedKey = Base64.decodeBase64(BASE64_SECRET);
        Key key = Keys.hmacShaKeyFor(encodedKey);
        return key;
    }

    /**
     * 创建Token
     * @param userId
     * @return
     */
    public String createToken(String userId, JwtUser jwtUser) {
        String token = jwtBuilder
                // 加入ID确保生成的 Token 都不一致
                .setId(IdUtil.simpleUUID())
                .claim(AUTHORITIES_KEY, userId)
                .setSubject(userId)
                .compact();
        redisUtil.set("login:"+userId,jwtUser,1L, TimeUnit.HOURS);
        return token;
    }

    /**
     * 解析 jtw 保存
     * @param token
     */
    public void parseJwt(String token) {
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            // 去掉令牌前缀
            token = token.replace("Bearer ", "");
        } else {
            log.debug("非法Token：{}", token);
        }

        Claims claims = jwtParser.parseClaimsJws(token).getBody();
        String userId = claims.getSubject();
        JwtUser jwtUser = (JwtUser)redisUtil.get("login:" + userId);
        if(ObjectUtil.isEmpty(jwtUser)) {
            throw new RuntimeException("请求未认证");
        }
        Object authoritiesStr = claims.get(AUTHORITIES_KEY);
        Collection<? extends GrantedAuthority> authorities =
                ObjectUtil.isNotEmpty(authoritiesStr) ?
                        Arrays.stream(authoritiesStr.toString().split(","))
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList()) : Collections.emptyList();

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(jwtUser,"",authorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}
