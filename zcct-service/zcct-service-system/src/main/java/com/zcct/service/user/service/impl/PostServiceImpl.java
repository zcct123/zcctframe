package com.zcct.service.user.service.impl;

import com.zcct.service.user.domain.Post;
import com.zcct.service.user.repository.PostRepository;
import com.zcct.service.user.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostRepository, Post> implements PostService {

}
