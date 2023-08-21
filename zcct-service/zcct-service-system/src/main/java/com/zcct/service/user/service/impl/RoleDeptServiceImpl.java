package com.zcct.service.user.service.impl;

import com.zcct.service.user.domain.RoleDept;
import com.zcct.service.user.repository.RoleDeptRepository;
import com.zcct.service.user.service.RoleDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和部门关联表 服务实现类
 * </p>
 *
 * @author zcct
 * @since 2022-08-27
 */
@Service
public class RoleDeptServiceImpl extends ServiceImpl<RoleDeptRepository, RoleDept> implements RoleDeptService {

}
