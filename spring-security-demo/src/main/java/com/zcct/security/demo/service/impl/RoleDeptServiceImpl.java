package com.zcct.security.demo.service.impl;

import com.zcct.security.demo.domain.RoleDept;
import com.zcct.security.demo.repository.RoleDeptRepository;
import com.zcct.security.demo.service.RoleDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和部门关联表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-29
 */
@Service
public class RoleDeptServiceImpl extends ServiceImpl<RoleDeptRepository, RoleDept> implements RoleDeptService {

}
