package com.zcct.security.demo.service.impl;

import com.zcct.security.demo.domain.UserPost;
import com.zcct.security.demo.repository.UserPostRepository;
import com.zcct.security.demo.service.UserPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostRepository, UserPost> implements UserPostService {

}
