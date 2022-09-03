package com.zcct.security.demo.service.impl;

import com.zcct.security.demo.domain.Post;
import com.zcct.security.demo.repository.PostRepository;
import com.zcct.security.demo.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostRepository, Post> implements PostService {

}
