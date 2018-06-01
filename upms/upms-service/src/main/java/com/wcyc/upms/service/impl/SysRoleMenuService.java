package com.wcyc.upms.service.impl;

import com.wcyc.base.common.base.service.impl.BaseService;
import com.wcyc.upms.api.entity.SysRoleMenu;
import com.wcyc.upms.api.service.ISysRoleMenuService;
import com.wcyc.upms.dao.SysRoleMenuDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chen
 * @date 2017/10/26
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        interfaceClass = ISysRoleMenuService.class
)
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysRoleMenuService  extends BaseService<SysRoleMenuDao, SysRoleMenu> implements ISysRoleMenuService {
}
