package com.zcct.service.user.service.impl;

import com.zcct.service.user.domain.UserPost;
import com.zcct.service.user.repository.UserPostRepository;
import com.zcct.service.user.service.UserPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostRepository, UserPost> implements UserPostService {

}
