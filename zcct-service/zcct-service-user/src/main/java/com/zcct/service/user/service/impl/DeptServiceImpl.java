package com.zcct.service.user.service.impl;

import com.zcct.service.user.api.admin.Dept;
import com.zcct.service.user.repository.DeptRepository;
import com.zcct.service.user.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptRepository, Dept> implements DeptService {

}
