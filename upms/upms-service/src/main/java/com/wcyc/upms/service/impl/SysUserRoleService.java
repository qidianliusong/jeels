package com.wcyc.upms.service.impl;

import com.wcyc.base.common.base.service.impl.BaseService;
import com.wcyc.upms.api.entity.SysUserRole;
import com.wcyc.upms.api.service.ISysUserRoleService;
import com.wcyc.upms.dao.SysUserRoleDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chen
 * @date 2017/9/1
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 系统用户角色中间表
 */
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        interfaceClass = ISysUserRoleService.class
)
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysUserRoleService extends BaseService<SysUserRoleDao, SysUserRole> implements ISysUserRoleService {
}
