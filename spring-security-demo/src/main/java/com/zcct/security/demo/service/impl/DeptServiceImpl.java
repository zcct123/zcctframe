package com.zcct.security.demo.service.impl;

import com.zcct.security.demo.domain.Dept;
import com.zcct.security.demo.repository.DeptRepository;
import com.zcct.security.demo.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptRepository, Dept> implements DeptService {

}
